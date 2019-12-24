package com.foolishpuma.kata.fizzbuzz

fun fizzBuzz(number: Int): String {
    return if (number.rem(3) == 0) {
        return "Fizz"
    } else {
        number.toString()
    }
}