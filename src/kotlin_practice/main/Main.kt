package kotlin_practice.main

fun main() {
    while (true) {
       println("-------------------------------------")
       println("[1. Exit, 2. Collections, 3. Fibonacci]")
       print("Enter your input: ")

       when (readln().toIntOrNull() ?: 0) {
           0 -> {
               println("Please enter valid input: ")
               continue
           }
           1 -> {
               println("Exiting the program....")
               break
           }
           2 -> {
               kotlinCollection()
               continue
           }
           3 -> {
               fibonacciSeries()
               continue
           }
           else -> {
               println("Please enter valid input: ")
               continue
           }
       }

   }
}

fun kotlinCollection() {
    /* To prevent unwanted modifications, you can create a read-only view
     * of a mutable list by assigning it to a List: <- Type Casting
     */
    print("Enter the size of the list: ")
    val size: Int = readln().toIntOrNull() ?: 0
    val mutableList: MutableList<String> = mutableListOf()
    val list: List<String> = mutableList

    if (size > 0) {
        for (i: Int in 0 until size) {
            print("Enter element ${i+1}: ")
            mutableList.add(
                index = i,
                element = readln()
            )
        }
    } else {
        println("Size is invalid!")
        return
    }

    list.also(::println)
}

fun fibonacciSeries() {
    var first: Int = 0
    var second: Int = 1
    var next: Int
    print("Enter the number: ")
    val num: Int = readln().toInt()

    print("Fibonacci Series: 0 1 ") // size: 5 = [ 0 1 1 2 3 5 8 13 ]
    for (i: Int in 0 .. num) {
        next = first + second
        print("$next ")
        first = second
        second = next
    }
    println()
}