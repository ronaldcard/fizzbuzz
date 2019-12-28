package com.foolishpuma.kata.fizzbuzz

fun fizzBuzz(number: Int): String {
    return when {
        number.isDivisibleBy15() -> "FizzBuzz"
        number.isDivisibleBy3() -> "Fizz"
        number.isDivisibleBy5() -> "Buzz"
        else -> number.toString()
    }
}

fun Int.isDivisibleBy3() = rem(3) == 0
fun Int.isDivisibleBy5() = rem(5) == 0
fun Int.isDivisibleBy15() = rem(15) == 0