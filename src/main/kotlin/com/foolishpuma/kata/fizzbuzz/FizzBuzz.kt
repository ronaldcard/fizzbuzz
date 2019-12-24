package com.foolishpuma.kata.fizzbuzz

fun fizzBuzz(number: Int): String {
    return when {
        number.rem(3) == 0 -> "Fizz"
        number.rem(5) == 0 -> "Buzz"
        else -> number.toString()
    }
}