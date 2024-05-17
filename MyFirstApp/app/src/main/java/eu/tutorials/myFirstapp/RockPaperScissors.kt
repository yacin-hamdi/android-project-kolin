package eu.tutorials.myFirstapp

fun main(){
    var computerChoice = ""
    var playerChoice = ""

    while(playerChoice != "Rock" && playerChoice != "Paper" && playerChoice != "Scissors"){
        println("Rock, Paper or Scissors? ENter your choice")
        playerChoice = readln()

    }


    val randomNumber = (1..3).random()
    when (randomNumber) {
        1 -> {
            computerChoice = "Rock"
        }
        2 -> {
            computerChoice = "Paper"

        }
        3 -> {
            computerChoice = "Scissors"
        }
    }
    println(computerChoice)

    val winner = when{
        playerChoice == computerChoice -> "Tie"
        playerChoice == "Rock" && computerChoice == "Scissors" -> "Player"
        playerChoice == "Paper" && computerChoice == "Rock" -> "Player"
        playerChoice == "Scissors" && computerChoice == "Paper" -> "Player"
        else -> "Computer"
    }

    if(winner == "Tie"){
        println(winner)
    }else{
        println("$winner won!")
    }




}