package com.alexisayala.masterclass.todo

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexisayala.masterclass.R
import com.alexisayala.masterclass.todo.TaskCategories.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {
    private var categories = listOf(
        Personal, Business, Other
    )

    private val tasks = mutableListOf(
        Tasks(name = "Business", Business),
        Tasks(name = "Personal", Personal),
        Tasks(name = "Other", Other)
    )
    private lateinit var recicleViewCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TaskAdapter

    private lateinit var fabAddTask: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        initComponent()
        initListeners()
        initUI()
    }

    private fun initComponent() {
        recicleViewCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)

    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories) { position -> updateCategories(position) }
        recicleViewCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recicleViewCategories.adapter = categoriesAdapter

        tasksAdapter = TaskAdapter(tasks) { onItemSelected(it) }
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }


    private fun onItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTask()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener {
            showDialog()
        }

    }


    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btAddTask: Button = dialog.findViewById(R.id.btAddTask)
        val edTask: EditText = dialog.findViewById(R.id.edTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btAddTask.setOnClickListener {
            val currentTask = edTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategories = when (selectedRadioButton.text) {
                    getString(R.string.dialog_business) -> Business
                    getString(R.string.dialog_personal) -> Personal
                    else -> Other
                }
                tasks.add(Tasks(currentTask, currentCategory))
                updateTask()
                dialog.hide()
            }
        }

        dialog.show()
    }

    private fun updateCategories(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTask()
    }

    private fun updateTask() {
        val selectedCategories: List<TaskCategories> = categories.filter { it.isSelected }
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        tasksAdapter.tasks = newTasks
        tasksAdapter.notifyDataSetChanged()
    }
}