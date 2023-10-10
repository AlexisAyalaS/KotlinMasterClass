package com.alexisayala.masterclass.kotlinExercises

fun main() {
    val morningNotifications: Int = 51
    val eveningNotifications: Int = 135

    printNotificationSummary(morningNotifications)
    printNotificationSummary(eveningNotifications)
}

fun printNotificationSummary(notifications: Int) {
    if (notifications <= 0) {
        println("You have 0 notifications")
    }
    if (notifications in 0..99) {
        println("You have $notifications notifications.")
    }
    if (notifications >= 99) {
        println("Your phone is blowing up! You have $notifications+ notifications.")
    }
}