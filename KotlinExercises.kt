package pl.pjatk.s25373.kotlindemo

/**
 * Exercise 1:
 * Define a function that returns the maximum of two numbers.
 */
fun maxOf(a: Int, b: Int): Int = if (a > b) a else b

/**
 * Exercise 2:
 * Write a function that returns the length of the given string.
 */
fun stringLength(str: String): Int = str.length

/**
 * Exercise 3:
 * Create a nullable variable and safely print its value.
 */
fun printNullable() {
    val name: String? = "Kotlin"
    println(name ?: "Name is null")
}

/**
 * Exercise 4:
 * Create a when expression that returns a string based on the value.
 */
fun describe(obj: Any): String =
    when (obj) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long number"
        !is String -> "Not a string"
        else       -> "Unknown"
    }

/**
 * Exercise 5:
 * Write a loop that prints numbers from 1 to 5.
 */
fun printRange() {
    for (i in 1..5) println(i)
}

/**
 * Exercise 6:
 * Create a class `Person` with a property `name`.
 */
class Person(val name: String)

/**
 * Exercise 7:
 * Define a data class `User` with `name` and `age`.
 */
data class User(val name: String, val age: Int)

/**
 * Exercise 8:
 * Use a lambda to filter even numbers from a list.
 */
fun filterEvens(numbers: List<Int>): List<Int> = numbers.filter { it % 2 == 0 }

/**
 * Exercise 9:
 * Create an extension function on String that returns the first character.
 */
fun String.firstChar(): Char = this.first()

/**
 * Exercise 10:
 * Declare a function that uses a default parameter.
 */
fun greet(name: String = "World") = "Hello, $name!"

/**
 * Exercise 11:
 * Use a smart cast to check if a variable is a String and print its length.
 */
fun printStringLength(x: Any) {
    if (x is String) {
        println("Length: ${x.length}")
    }
}

/**
 * Exercise 12:
 * Create a generic function that returns a list with the given elements.
 */
fun <T> makeList(vararg items: T): List<T> = listOf(*items)
