package com.foolishpuma.kata.fizzbuzz

import org.assertj.core.api.Assertions.anyOf
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Condition
import org.junit.Ignore
import org.junit.Test
import java.lang.NumberFormatException
import java.util.function.Predicate


class FizzBuzzTests {

    private val testRange = IntRange(1, 101)
    private val isFizz = Condition<String>(Predicate<String> { it == "Fizz" }, "is Fizz")
    private val isBuzz = Condition<String>(Predicate<String> { it == "Buzz" }, "is Buzz")
    private val isFizzBuzz = Condition<String>(Predicate<String> { it == "FizzBuzz" }, "is FizzBuzz")
    private val isNumeric = Condition<String>(Predicate<String> { it.isNumeric() }, "is Numeric")

    @Test
    fun `every result is either "Fizz", "Buzz", or a numeric string`() {
        testRange.map { number ->
            assertThat(fizzBuzz(number)).`is`(anyOf(isFizz, isBuzz, isFizzBuzz, isNumeric))
        }
    }

    @Test
    fun `every numeric result corresponds to its ordinal position`() {

        testRange.map { number ->
            val result = fizzBuzz(number)
            if (result.isNumeric()) {
                assertThat(result.toInt()).isEqualTo(number)
            }
        }
    }

    @Ignore
    @Test
    fun `every third result contains "Fizz"`() {

        testRange.step(3).map { number ->
            println("[$number]")
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