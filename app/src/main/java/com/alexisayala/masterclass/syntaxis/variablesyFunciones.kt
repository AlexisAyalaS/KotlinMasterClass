package com.alexisayala.masterclass.syntaxis

fun main(){
    /**
     * Numeric Variables
     */
    //int integer numbers
    val age:Int = 30

    //Long integer very long
    val exampleLong:Long =30

    //Float numbers with decimal
    val exampleFloat:Float = 20.5f;

    //double numbers decimal with many decimals
    val exampleDouble:Double = 20.123;

    /**
     *Character Variables
     */

    val example:Char = '1';

    val exampleString:String= "hey there";

    /**
     * Boolean variables
     */

    val exampleBoolean:Boolean = true

    showName("Elisita")
}

fun showName(name:String){
    println("the name to show is: $name")
}