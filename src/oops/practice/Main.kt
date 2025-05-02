package oops.practice

import java.time.LocalTime
import kotlin.time.Duration

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
class Product(
    val id: Int,
    val name: String,
    var price: Double,
    var inStock: Boolean = true
    ) {

    // The `init` block is the proper way to execute initialization
    // code for the primary constructor in Kotlin.
    // It runs right after the primary constructor parameters are assigned.
    init {
        println("Product ID: ${this.id}\nProduct Name: ${this.name}\nProduct Price: $price")
    }

    // Method
    fun applyDiscount(discount: Double) {
        price -= price * (discount / 100)
        println("After $discount% discount price: $price")
    }
}

/*
* 2. Encapsulation.
* Encapsulation is about hiding internal states and
* requiring all interaction to be performed through an object's methods.
*/

class BankAccount (private val bankAccountNo: Int) {

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
open class Notification(val message: String) {
    open fun sendMessage() {
        println("Sending notification: $message")
    }

    fun receiveMessage() {} // methods which are not open cannot be overridden
}

// Derived/Child class
class EmailNotification(
    message: String,
    val recipient: String
) : Notification(message) {

    override fun sendMessage() {
//        super.sendMessage()
        println("Sending email to $recipient: $message")
    }

    fun greet() {
        println("Hello! I am ${this.recipient}.")
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

abstract class PaymentMethod {
    abstract fun processPayment(amount: Double) : Boolean
}

class CreditCard : PaymentMethod() {
    override fun processPayment(amount: Double): Boolean {
        println("Processing $amount via Credit Card")
        return true
    }
}

class GooglePay : PaymentMethod() {
    override fun processPayment(amount: Double): Boolean {
        println("Processing $amount via GooglePay")
        return true
    }
}

fun checkout(amount: Double, paymentMethod: PaymentMethod) {
    if (paymentMethod.processPayment(amount)) {
        println("Payment successful")
    } else {
        println("Payment unsuccessful")
    }
}

/*
* 5. Abstraction.
* Abstraction allows you to hide complex implementation details and
* show only the necessary features.
*/

abstract class Vehicle {
    abstract val maxSpeed: Int
    abstract val fuelType: String
    abstract var initialSpeed: Int
    abstract fun start()
    abstract fun stop()
}

class Scooter() : Vehicle() {
    override val maxSpeed: Int = 180
    override val fuelType: String = "Petrol"
    override var initialSpeed: Int = 0

    init {
        start()
    }

    override fun start() {
        println("Scooter engine started!")
        initialSpeed()
    }

    fun setSpeed(speed: Int) {
        this.initialSpeed = speed
        initialSpeed()
    }

    fun initialSpeed() {
        println("Current Speed: $initialSpeed")
    }

    override fun stop() {
        println("Scooter engine stopped!")
        setSpeed(0)
    }
}

/* 6. Interface
* In kotlin, Interfaces are similar to abstract classes but can be implemented
* by classes that already extend another class.
*/

open class Recorder {
    fun startRecorder() {
        println("Recorder started")
    }

    fun stopRecorder() {
        println("Recorder stopped")
    }
}

interface VolumeController {
    fun increase()
    fun decrease()
}

interface MediaController {
    fun play()
    fun pause()
    fun stop()
}

class MediaPlayer() : Recorder(), MediaController,  VolumeController {
    override fun play() {
        println("Playing media")
    }

    override fun pause() {
        println("Media paused")
    }

    override fun stop() {
        println("Media stopped")
    }

    override fun increase() {
        println("Volume up")
    }

    override fun decrease() {
        println("Volume down")
    }
}

/*
* 8. Singleton with Object Declaration
* A singleton ensures that a class has only one instance and
* provides a global point of access to it.
*/

// Singleton logger
object Logger {
    fun log(message: String) {
        val timestamp: LocalTime = java.time.LocalTime.now()
        println("[$timestamp]: $message")
    }
}

// main entry point of execution
fun main() {
//    Classes & Objects
//    Creating objects
//    val laptop = Product(1, "HP", 50000.0, true)
//    laptop.applyDiscount(20.0) // calling the object's method

//    Encapsulation
//    val obj = BankAccount()
//    obj.showBalance()
//    obj.creditBalance(15000.0)
//    obj.debitBalance(10000.0)

//    Polymorphism
//    val emailNotification = EmailNotification("Hello Android!", "Brijesh")
//    emailNotification.sendMessage()
//    emailNotification.greet()

//    val cirObj = Circle(3.0)
//    val rectObj = Rectangle(2.0, 3.0)
//
//    printArea(cirObj)
//    printArea(rectObj)

//    val creditCard = CreditCard()
//    val googlePay = GooglePay()
//    checkout(500.0, googlePay)

//    Abstraction
//    val dio = Scooter()
//    dio.setSpeed(40)
//    dio.stop()

//    Interfaces
//    val myMediaPlayer = MediaPlayer()
//    myMediaPlayer.play()
//    myMediaPlayer.increase()
//    myMediaPlayer.startRecorder()
//    myMediaPlayer.pause()
//    myMediaPlayer.decrease()
//    myMediaPlayer.stopRecorder()
//    myMediaPlayer.stop()

//    Singleton
//    Same instance everywhere
    Logger.log("Hello! World")
}