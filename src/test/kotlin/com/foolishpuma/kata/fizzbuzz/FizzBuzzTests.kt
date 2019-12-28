package com.foolishpuma.kata.fizzbuzz

import org.assertj.core.api.Assertions.anyOf
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Condition
import org.junit.Test
import java.util.function.Predicate


private const val FIZZ = "Fizz"
private const val BUZZ = "Buzz"
private const val FIZZ_BUZZ = "FizzBuzz"

class FizzBuzzTests {

    private val fizzBuzzes = (1..100).map { fizzBuzz(it) }

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
                assertThat(result.toInt()).isEqualTo(fizzBuzzes.indexOf(result).ordinalPosition())
            }
    }

    @Test
    fun `every third result contains "Fizz"`() {

        fizzBuzzes
            .filterIndexed { index, _ -> index.ordinalPosition().isDivisibleBy3() }
            .forEach { result ->
                assertThat(result).contains(FIZZ)
            }
    }

    @Test
    fun `every fifth result contains "Buzz"`() {

        fizzBuzzes
            .filterIndexed { index, _ -> index.ordinalPosition().isDivisibleBy5() }
            .forEach { result ->
                assertThat(result).contains(BUZZ)
            }
    }

    @Test
    fun `every fifteenth result is "FizzBuzz"`() {

        fizzBuzzes
            .filterIndexed { index, _ -> index.ordinalPosition().isDivisibleBy15() }
            .forEach { result ->
                assertThat(result).contains(FIZZ_BUZZ)
            }
    }

    @Test
    fun `the ordinal position of every "Fizz" result is divisible by 3`() {

        fizzBuzzes
            .filter { result -> result == FIZZ }
            .forEach { result ->
                assertThat(fizzBuzzes.indexOf(result).ordinalPosition()).`is`(divisibleBy3())
            }
    }

    @Test
    fun `the ordinal position of every "Buzz" result is divisible by 5`() {

        fizzBuzzes
            .filter { result -> result == BUZZ }
            .forEach { result ->
                assertThat(fizzBuzzes.indexOf(result).ordinalPosition()).`is`(divisibleBy5())
            }
    }

    @Test
    fun `the ordinal position of every "FizzBuzz" result is divisible by 15`() {

        fizzBuzzes
            .filter { result -> result == FIZZ_BUZZ }
            .forEach { result ->
                assertThat(fizzBuzzes.indexOf(result).ordinalPosition()).`is`(divisibleBy15())
            }
    }
}

private fun isFizz() = Condition<String>(Predicate<String> { it == FIZZ }, "is Fizz")
private fun isBuzz() = Condition<String>(Predicate<String> { it == BUZZ }, "is Buzz")
private fun isFizzBuzz() = Condition<String>(Predicate<String> { it == FIZZ_BUZZ }, "is FizzBuzz")
private fun isNumeric() = Condition<String>(Predicate<String> { it.isNumeric() }, "is Numeric")
private fun divisibleBy3() = Condition<Int>(Predicate<Int> { it.isDivisibleBy3() }, "is divisible by 3")
private fun divisibleBy5() = Condition<Int>(Predicate<Int> { it.isDivisibleBy5() }, "is divisible by 5")
private fun divisibleBy15() = Condition<Int>(Predicate<Int> { it.isDivisibleBy15() }, "is divisible by 15")

private fun Int.isDivisibleBy3() = rem(3) == 0
private fun Int.isDivisibleBy5() = rem(5) == 0
private fun Int.isDivisibleBy15() = rem(15) == 0
private fun Int.ordinalPosition() = plus(1)

// TODO - is there a better way to do this?
private fun String.isNumeric(): Boolean {
    return try {
        toInt()
        true
    } catch (numberFormatException: NumberFormatException) {
        false
    }
}