package oops.practice

/*
* Much like regular properties,
* properties declared in the primary constructor
* can be mutable (var) or read-only (val).
* If the constructor has annotations or visibility modifiers,
* the constructor keyword is required and the modifiers go before it:
*/

/*
* class Customer public @Inject constructor(name: String) { /*...*/ }
*/

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

class BankAccount public constructor() {

    private var balance: Double = 0.0

    /*
    * In Kotlin, a class can have multiple init blocks.
    * These blocks are executed in the order they appear in the class body,
    * after the primary constructor is executed.
    * They are used to initialize properties or perform setup logic
    * when an instance of the class is created.
    */

    init {
        print("Enter your current balance: ")
        balance = readln().toDouble().also(::println)
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

/*
* 3. Inheritance.
* Inheritance allows a class to inherit properties and
* methods from another class.
*/

// Base/Parent class
open class Animal(private val name: String) {
    open fun makeSound() {
        println("Some generic animal sound")
    }

    fun animalColor() {} // methods which are not open cannot be overridden
}

// Derived/Child class
class Dog(name: String, private val breed: String) : Animal(name) {

    override fun makeSound() {
//        super.makeSound()
        println("Woof! Woof!")
    }

    fun greet() {
        println("Hello! I am ${this.breed}.")
    }
}

/*
* 4. Polymorphism.
* Polymorphism allows objects of different classes
* to be treated as objects of a common superclass.
*/

/*
* There are 2 types of Polymorphism.
* 1. Runtime Polymorphism - Method Overriding - the compiler then resolves which functions
* we are trying to call based on the type of parameters and more.
* 2. Compile-time Polymorphism - Method Overloading - Here, the compiler resolves,
* at run-time, which method to execute.
*/

open class Shape {
    open fun calculateArea(): Double {
        return 0.0
    }
}

class Circle(val radius: Double) : Shape() {
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun calculateArea(): Double {
        return width * height
    }
}

// Polymorphism in action
fun printArea(shape: Shape) {
    println("Area: ${shape.calculateArea()}")
}

// main entry point of execution
fun main() {
//    // Creating objects
//    val p1 = Person(name = "Brijesh", age = 25)
//    p1.canVote() // calling the object's method

//    val obj = BankAccount()
//    obj.showBalance()
//    obj.creditBalance(15000.0)
//    obj.debitBalance(10000.0)

//    val dogObj = Dog("Doggy", "Indian")
//    dogObj.makeSound()
//    dogObj.greet()

//    val cirObj = Circle(3.0)
//    val rectObj = Rectangle(2.0, 3.0)
//
//    printArea(cirObj)
//    printArea(rectObj)
}