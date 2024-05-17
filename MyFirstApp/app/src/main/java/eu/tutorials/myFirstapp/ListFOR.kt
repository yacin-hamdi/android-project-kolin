package eu.tutorials.myFirstapp

fun main(){
    val shoppingList = listOf("Processor", "RAM", "GPU", "SSD")
    val mShoppingList = mutableListOf("CPU", "RAM", "GPU", "SSD")
    mShoppingList.add("cooling system")
    mShoppingList.remove("GPU")
    mShoppingList.add("GPU RTX 4090")
    println(mShoppingList.size)
    println(mShoppingList)
    mShoppingList.removeAt(2)
    println(mShoppingList)
    mShoppingList.removeAt(1)
    mShoppingList.add(index=2, element="RAM")
    println(mShoppingList)
    println(mShoppingList[3])
    mShoppingList[3] = "GPU RX7800XT"
    println(mShoppingList)
    mShoppingList[2] = "ROM"
    println(mShoppingList)
    println(mShoppingList.contains("ROM"))


//    val fruitsList = mutableListOf("orange", "banana")
//    println(fruitsList)
//    fruitsList.add("blueberry")
//    println(fruitsList)
//    fruitsList.remove("orange")
//    println(fruitsList)
//    val hasBanana = fruitsList.contains("banana")
//    if(hasBanana){
//        println("the list contain banana")
//    }else{
//        println("the list doesn't contains banana")
//    }

//    for(item in mShoppingList){
//        println(item)
//        if(item == "ROM"){
//            break
//        }
//    }
//
//    for(index in 0 until mShoppingList.size){
//        println("item ${mShoppingList[index]} is at index $index")
//    }

    val numbers = mutableListOf(4, 5, 3, 6, 7)
    for (i in 0 until numbers.size){
        numbers[i] *= 2
    }

    println(numbers)
}