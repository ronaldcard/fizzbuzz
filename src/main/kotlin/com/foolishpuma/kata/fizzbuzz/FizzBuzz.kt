package com.foolishpuma.kata.fizzbuzz

fun <T> Sequence<T>.repeat() = sequence { while (true) yieldAll(this@repeat) }

fun fizzes() = sequenceOf("", "", "Fizz").repeat()
fun buzzes() = sequenceOf("", "", "", "", "Buzz").repeat()
fun words() = fizzes().zip(buzzes()) { fizzValue, buzzValue -> "$fizzValue$buzzValue" }
fun numbers() = generateSequence(1) { it + 1 }.repeat()
fun fizzBuzzes(): List<String> =
    words()
        .zip(numbers()) { word, number ->
            if (word.isEmpty()) {
                number.toString()
            } else {
                word
            }
        }
        .take(100)
        .toList()

fun fizzBuzz(number: Int): String {
    return fizzBuzzes().toList()[number - 1]
}