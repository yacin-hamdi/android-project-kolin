package eu.tutorials.myFirstapp

fun main(){
    println("Please enter a number.")
    val inputString = readln()
    val inputNumber = inputString.toInt()
    val multiplier = 5
    println("the result of operation is: ${inputNumber * multiplier}")
}