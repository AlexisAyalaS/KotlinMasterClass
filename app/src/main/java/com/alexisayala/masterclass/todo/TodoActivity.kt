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
    private val categories = listOf(
        Personal, Business, Other
    )

    private val tasks = mutableListOf(
        Tasks(name = "BusinessTest", Business),
        Tasks(name = "PersonalTest", Personal),
        Tasks(name = "OtherTest", Other)
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
        categoriesAdapter = CategoriesAdapter(categories)
        recicleViewCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recicleViewCategories.adapter = categoriesAdapter

        tasksAdapter = TaskAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
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

    private fun updateTask() {
        tasksAdapter.notifyDataSetChanged()
    }
}