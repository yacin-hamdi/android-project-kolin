package eu.tutorials.myFirstapp

fun main(){
     val myAccount = BankAccount("my", 12280.3)
    myAccount.deposit(200.0)
    myAccount.withdraw(1200.0)
    myAccount.deposit(3000.0)
    myAccount.deposit(3333.14)
    myAccount.withdraw(5000.0)
    myAccount.displayTransactionHistory()
    myAccount.acctBalance()

    val johnAcc = BankAccount("john", 0.0)
    johnAcc.deposit(100.0)
    johnAcc.deposit(300.0)
    johnAcc.withdraw(10.0)
    johnAcc.displayTransactionHistory()
    johnAcc.acctBalance()
}