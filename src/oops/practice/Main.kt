package oops.practice

// Class definition -> With header defined primary constructor
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

// main entry point of execution
fun main() {
    // Creating objects
    val p1 = Person(name = "Brijesh", age = 25)
    p1.canVote() // calling the object's method
}