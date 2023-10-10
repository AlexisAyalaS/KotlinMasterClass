package com.alexisayala.masterclass.todo

sealed class TaskCategories {
    data object Personal : TaskCategories()
    data object Business : TaskCategories()
    data object Other : TaskCategories()
}