package eu.tutorials.myapp

class Offspring: Secondary(), Archery, Singer {
    override fun archery() {
        super.archery()
        println("Archery skills enhanced by Offspring")
    }

    override fun sing(){
        super.archery()
        println("Singing skills enhanced by Offspring")
    }
}