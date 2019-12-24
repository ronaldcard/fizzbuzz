package com.foolishpuma.kata.fizzbuzz

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FizzBuzzTests {

    @Test
    fun `when passed a number, fizzBuzz should return that number`() {

        val result = fizzBuzz(1)

        assertThat(result).isEqualTo("1")
    }
}