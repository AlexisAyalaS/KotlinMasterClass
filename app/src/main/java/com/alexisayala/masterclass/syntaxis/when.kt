package com.alexisayala.masterclass.syntaxis

fun main() {
    val semester = getSemester(5)
    println(semester)
}

fun getSemester(month: Int): String {
    return when (month) {
        in 1..6 -> "first semester"
        in 7..12 -> "second semester"
        else -> "Not valid month"
    }
}

fun getTrimester(month: Int) {
    when (month) {
        1, 2, 3 -> println("first trimester")
        4, 5, 6 -> println("second trimester")
        7, 8, 9 -> println("third trimester")
        10, 11, 12 -> println("fourth trimester")
        else -> println("Not valid month")
    }
}

fun getMonth(month: Int) {
    when (month) {
        1 -> println("January")
        2 -> println("February")
        3 -> println("March")
        4 -> println("April")
        5 -> println("May")
        6 -> println("Jun")
        7 -> println("July")
        8 -> println("August")
        9 -> println("September")
        10 -> println("October")
        11 -> println("November")
        12 -> println("December")
        else -> println("Not valid mail")
    }
}
