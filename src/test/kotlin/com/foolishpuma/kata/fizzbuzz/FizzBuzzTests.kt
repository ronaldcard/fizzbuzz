package com.foolishpuma.kata.fizzbuzz

import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test

class FizzBuzzTests {

    private val testRange = 1..101

    @Test
    fun `every result is either "Fizz", "Buzz", or a numeric string`() {

        testRange.map { number ->
            val result = fizzBuzz(number)
            assertThat(result).isIn("Fizz", "Buzz", "FizzBuzz", result.toIntOrNull().toString())
        }
    }

    @Ignore
    @Test
    fun `every numeric result corresponds to its ordinal position`() { }

    @Ignore
    @Test
    fun `every third result contains "Fizz"`() { }

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