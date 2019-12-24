package com.foolishpuma.kata.fizzbuzz

fun fizzBuzz(number: Int): String {
    return when {
        isDivisibleBy15(number) -> "FizzBuzz"
        isDivisibleBy3(number) -> "Fizz"
        isDivisibleBy5(number) -> "Buzz"
        else -> number.toString()
    }
}

fun isDivisibleBy3(number: Int) = number.rem(3) == 0
fun isDivisibleBy5(number: Int) = number.rem(5) == 0
fun isDivisibleBy15(number: Int) = isDivisibleBy3(number) && isDivisibleBy5(number)