package com.foolishpuma.kata.fizzbuzz

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FizzBuzzTests {

    private var fizzBuzzes =
        (1..101).map { number ->
            fizzBuzz(number)
        }

    @Test
    fun `every result is either "Fizz", "Buzz", or a numeric string`() {
        fizzBuzzes.forEach { actual ->
            assertThat(actual).isIn("Fizz", "Buzz", "FizzBuzz", actual.toIntOrNull().toString())
        }
    }

    @Test
    fun `when passed a number, fizzBuzz should return that number`() {
        assertThat(fizzBuzz(1)).isEqualTo("1")
    }

    @Test
    fun `when passed a number divisible by 3, fizzBuzz should return "Fizz"`() {
        assertThat(fizzBuzz(3)).isEqualTo("Fizz")
    }

    @Test
    fun `when passed a number divisible by 5, fizzBuzz should return "Buzz"`() {
        assertThat(fizzBuzz(5)).isEqualTo("Buzz")
    }

    @Test
    fun `when passed a number divisible by 15, fizzBuzz should return "FizzBuzz"`() {
        assertThat(fizzBuzz(15)).isEqualTo("FizzBuzz")
    }
}