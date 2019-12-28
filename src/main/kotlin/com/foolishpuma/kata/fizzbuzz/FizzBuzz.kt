package com.foolishpuma.kata.fizzbuzz

fun <T> Sequence<T>.infinite() = sequence { while (true) yieldAll(this@infinite) }

private val fizzes = sequenceOf("", "", "Fizz").infinite()
private val buzzes = sequenceOf("", "", "", "", "Buzz").infinite()
private val words = fizzes.zip(buzzes, String::plus)
private val numbers = generateSequence(1, Int::inc).infinite()
private val fizzBuzzes = words.zip(numbers, wordOrNumber())

private fun wordOrNumber(): (String, Int) -> String {
    return fun(word: String, number: Int): String {
        return if (word.isEmpty()) {
            number.toString()
        } else {
            word
        }
    }
}

fun fizzBuzz(number: Int) = fizzBuzzes.take(number).toList()[number.minus(1)]