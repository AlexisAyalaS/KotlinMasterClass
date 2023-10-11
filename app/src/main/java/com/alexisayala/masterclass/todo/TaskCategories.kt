package com.alexisayala.masterclass.todo

sealed class TaskCategories(var isSelected: Boolean = true) {
    data object Personal : TaskCategories()
    data object Business : TaskCategories()
    data object Other : TaskCategories()
}