package com.foolishpuma.kata.fizzbuzz

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FizzBuzzTests {

    @Test
    fun `when passed a number, fizzBuzz should return that number`() {

        val result = fizzBuzz(1)

        assertThat(result).isEqualTo("1")
    }

    @Test
    fun `when passed a number divisible by 3, fizzBuzz should return "Fizz"`() {

        val result = fizzBuzz(3)

        assertThat(result).isEqualTo("Fizz")
    }

    @Test
    fun `when passed a number divisible by 5, fizzBuzz should return "Buzz"`() {

        val result = fizzBuzz(5)

        assertThat(result).isEqualTo("Buzz")
    }
}