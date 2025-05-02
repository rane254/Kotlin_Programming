package kotlin_practice.main

fun main() {
    while (true) {
       println("-------------------------------------")
       println("[1. Exit, 2. Collections]")
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