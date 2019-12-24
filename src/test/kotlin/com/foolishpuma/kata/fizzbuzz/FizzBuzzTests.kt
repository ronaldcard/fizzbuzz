package com.foolishpuma.kata.fizzbuzz

import org.assertj.core.api.Assertions.fail
import org.junit.Test

class FizzBuzzTests {

    @Test
    fun `fail on purpose test`() {
        fail<String>("On Purpose!")
    }
}