package eu.tutorials.myFirstapp

fun main(){
    print("Enter your age as a whole number:")
    val age = readln().toInt()
    if(age in 18 .. 40){
        println("you can enter the club.")
    }else if(age >= 40){
        println("you cannot go into the club, please go home.")
    }else{
        println("Age not verified. Please contact support.")
    }
}