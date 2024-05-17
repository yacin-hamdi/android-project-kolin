package eu.tutorials.myFirstapp

fun main(){
    var daisy = Dog("daisy", "Dwarf poodle")
    daisy.age = 1
    println("${daisy.name} is a ${daisy.breed} and is ${daisy.age} yo")
    daisy.age = 2
    println("${daisy.name} is a ${daisy.breed} and is ${daisy.age} yo")

}