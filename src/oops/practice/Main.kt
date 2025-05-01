package oops.practice
/*
* 1. Classes and Objects
* Classes are blueprints that define properties and behaviors.
* Objects are instances of classes.
*/

// Class definition -> With header-defined primary constructor
class Person(val name: String, var age: Int) {

    // The `init` block is the proper way to execute initialization
    // code for the primary constructor in Kotlin.
    // It runs right after the primary constructor parameters are assigned.
    init {
        println("Name: ${this.name}\nAge: ${this.age}")
    }

    // Method
    fun canVote() {
        if (this.age >= 18) {
            println("${this.name} can vote.")
        } else {
            println("${this.name} cannot vote!")
        }
    }
}

/*
* 2. Encapsulation.
* Encapsulation is about hiding internal states and
* requiring all interaction to be performed through an object's methods.
*/

class BankAccount() {
    private var balance: Double = 0.0

    init {
        print("Enter your current balance: ")
        balance = readln().toDouble()
    }
    fun showBalance() {
        // Public methods to interact with private data
        println("-------------------------------")
        println("Your balance: ${this.balance}")
        println("-------------------------------")
    }

    fun creditBalance(amount: Double) {
        // Public methods to interact with private data
        if (amount > 0) {
            balance += amount
            println("Amount credited: $amount")
            showBalance()
        } else {
            println("Entered amount should be greater than 0")
        }
    }

    fun debitBalance(amount: Double) {
        // Public methods to interact with private data
        if (amount > 0 && amount <= this.balance) {
            balance -= amount
            println("Amount debited: $amount")
            showBalance()
        } else {
            println("Entered amount should be greater than 0 & less than balance")
            }
    }
}



// main entry point of execution
fun main() {
//    // Creating objects
//    val p1 = Person(name = "Brijesh", age = 25)
//    p1.canVote() // calling the object's method

    val obj = BankAccount()
    obj.showBalance()
    obj.creditBalance(15000.0)
    obj.debitBalance(10000.0)
}