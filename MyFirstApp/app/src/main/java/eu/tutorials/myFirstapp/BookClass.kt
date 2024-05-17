package eu.tutorials.myFirstapp

class Book(val title:String="Unknown", val author:String="Anonymous", val yearPublished:Int=2024) {
    init{

    }
}

fun main(){
    val book = Book()
    println("${book.title}, ${book.author}:${book.yearPublished}")
    val customBook = Book("custom book", "moon", 1995)
    println("${customBook.title}:${customBook.author}:${customBook.yearPublished}")
}