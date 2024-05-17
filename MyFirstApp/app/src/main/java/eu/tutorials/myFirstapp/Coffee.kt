package eu.tutorials.myFirstapp

data class CoffeeDetails(
    val name:String,
    val sugarCount:Int,
    val size:String,
    val creamAmount:Int
)

fun main(){
    val CoffeForMe = CoffeeDetails("me", 1, "xxl", 0)
    makeCoffee((CoffeForMe))
}

fun makeCoffee(coffeeDetails:CoffeeDetails){
    if(coffeeDetails.sugarCount == 1){
        println("coffee with ${coffeeDetails.sugarCount} spoon of sugar for ${coffeeDetails.name} and Cream:" +
                "${coffeeDetails.creamAmount}")
    }else if(coffeeDetails.sugarCount == 0){
        println("coffee with no sugar for ${coffeeDetails.name}")
    }else{
        println("coffee with ${coffeeDetails.sugarCount} spoons of sugar for $coffeeDetails.name")
    }
}