package com.alexisayala.masterclass.todo

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexisayala.masterclass.R

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvTask:TextView = view.findViewById(R.id.tvTask)
    private val cbTask: CheckBox = view.findViewById(R.id.cbTask)
    fun render(task: Tasks) {
        tvTask.text = task.name
    }
}