package eu.tutorials.myFirstapp

fun main(){
//    println("who's this coffee for:")
//    val name = readln()
//    println("how many spoons of sugar would you like:")
//    val sugarCount = readln().toInt()
//    makeCoffee(sugarCount, name)

//    val constantNumber = 2
//    var mutableString = "hello"
//    println(mutableString + constantNumber)
//    mutableString = "hi"
//    println(mutableString)
//
//    val myChar = 'a'
//    val unicode = '\u00AE'
//    println(myChar)
//    println(unicode)
//
//    var name = "moose"
//    println(name.uppercase())
//    name = "aycin"
//    println(name.lowercase() + name.uppercase())
//
//    var age = 20
//    if(age > 21){
//        println("welcome to the club")
//    }else{
//        println("you are too young")
//    }

//    var age = 0
//    println("Please enter your age as a whole number:")
//    age = readln().toInt()
//
//    if (age >= 40){
//        println("you can not go into the club")
//    }else if(age >=18) {
//        println("welcome to the club")
//    }else{
//
//
//        println("you are too young")
//    }

//    var count = 0
//    while(count < 9){
//        println("Count is $count")
//        count ++
//    }

//    println("enter number 1:")
//    val a = readln().toInt()
//    println("enter number 2:")
//    val b = readln().toInt()
//    val myResult = add(a, b)
//    println("$a + $b is $myResult")
//    println(divide(1, 2))
}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun divide(a:Int, b:Int):Double {
    val result:Double = a / b.toDouble()
    return result
}


fun makeCoffee(sugarCount:Int, name: String){
    if(sugarCount == 1){
        println("Coffee with $sugarCount spoon of sugar for $name")
    }else if(sugarCount > 1){
        println("Coffee with $sugarCount spoons of sugar for $name")
    }else{
        println("Coffee with no sugar for $name")
    }
}