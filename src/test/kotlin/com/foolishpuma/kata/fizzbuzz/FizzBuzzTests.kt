package com.foolishpuma.kata.fizzbuzz

import org.assertj.core.api.Assertions.anyOf
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Condition
import org.junit.Ignore
import org.junit.Test
import java.lang.NumberFormatException
import java.util.function.Predicate


class FizzBuzzTests {

    private val fizzBuzzes = (1..101).map { fizzBuzz(it) }

    @Test
    fun `every result is either "Fizz", "Buzz", or a numeric string`() {

        fizzBuzzes.forEach { result ->
            assertThat(result).`is`(anyOf(isFizz(), isBuzz(), isFizzBuzz(), isNumeric()))
        }
    }

    @Test
    fun `every numeric result corresponds to its ordinal position`() {

        fizzBuzzes
            .filter { result -> result.isNumeric() }
            .forEach { result ->
                val ordinalPosition = fizzBuzzes.indexOf(result) + 1
                assertThat(result.toInt()).isEqualTo(ordinalPosition)
            }
    }

    @Test
    fun `every third result contains "Fizz"`() {

        fizzBuzzes
            .filterIndexed { index, _ -> (index + 1).rem(3) == 0 }
            .forEach { result ->
                assertThat(result).contains("Fizz")
            }
    }

    @Ignore
    @Test
    fun `every fifth result contains "Buzz"`() {}

    @Ignore
    @Test
    fun `every fifteenth result is "FizzBuzz"`() {}

    @Ignore
    @Test
    fun `the ordinal position of every "Fizz" result is divisible by 3`() {}

    @Ignore
    @Test
    fun `the ordinal position of every "Buzz" result is divisible by 5`() {}

    @Ignore
    @Test
    fun `the ordinal position of every "FizzBuzz" result is divisible by 15`() {}

    private fun isFizz() = Condition<String>(Predicate<String> { it == "Fizz" }, "is Fizz")
    private fun isBuzz() = Condition<String>(Predicate<String> { it == "Buzz" }, "is Buzz")
    private fun isFizzBuzz() = Condition<String>(Predicate<String> { it == "FizzBuzz" }, "is FizzBuzz")
    private fun isNumeric() = Condition<String>(Predicate<String> { it.isNumeric() }, "is Numeric")

    // TODO - is this the best way to do this?
    private fun String.isNumeric(): Boolean {
        return try {
            toInt()
            true
        } catch (numberFormatException: NumberFormatException) {
            false
        }
    }
//    @Test
//    fun `when passed a number, fizzBuzz should return that number`() {
//        assertThat(fizzBuzz(1)).isEqualTo("1")
//    }
//
//    @Test
//    fun `when passed a number divisible by 3, fizzBuzz should return "Fizz"`() {
//        assertThat(fizzBuzz(3)).isEqualTo("Fizz")
//    }
//
//    @Test
//    fun `when passed a number divisible by 5, fizzBuzz should return "Buzz"`() {
//        assertThat(fizzBuzz(5)).isEqualTo("Buzz")
//    }
//
//    @Test
//    fun `when passed a number divisible by 15, fizzBuzz should return "FizzBuzz"`() {
//        assertThat(fizzBuzz(15)).isEqualTo("FizzBuzz")
//    }
}