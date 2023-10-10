package com.alexisayala.masterclass.syntaxis

fun main() {
    mutableList()
}

fun mutableList(){
    var weekDays:MutableList<String> = mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    weekDays.add(0, "Alexday")
    println(weekDays)
}

fun inmutableList() {
    val readOnly: List<String> =
        listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    //    println(readOnly.last())
    //    println(readOnly.first())

    //filtrar
    val example = readOnly.filter { it.contains("t") }
    //    println(example)

    //iterar
    readOnly.forEach { day -> println(day) }

}