package com.alexisayala.masterclass.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexisayala.masterclass.R

class TodoActivity : AppCompatActivity() {
    private val categories = listOf(
        TaskCategories.Personal,
        TaskCategories.Business,
        TaskCategories.Other
    )
    private lateinit var recicleViewCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView
//    private lateinit var tasksAdapter:

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
    }

    private fun initListeners() {}
    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        recicleViewCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recicleViewCategories.adapter = categoriesAdapter
    }
}