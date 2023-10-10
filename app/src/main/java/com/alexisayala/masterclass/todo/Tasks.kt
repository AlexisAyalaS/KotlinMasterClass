package com.alexisayala.masterclass.todo

data class Tasks(val name: String, val category: TaskCategories, var isSelected: Boolean = false) {

}