# FizzBuzz - Kata

## Rules - Original
* Write a program that prints the numbers from 1 to 100.
* For each multiple of three, print "Fizz" instead of the number.
* For each multiple of five, print "Buzz" instead of the number.
* For numbers which are multiples of both three and five, print "FizzBuzz" instead of number.


## Truths
* Every result is "Fizz", "Buzz", "FizzBuzz" or a numeric string.
* Every numeric result corresponds to its ordinal position.
* Every third result contains "Fizz".
* Every fifth result contains "Buzz".
* Every fifteenth result is "FizzBuzz".
* The ordinal position of every "Fizz" result is divisible by 3.
* The ordinal position of every "Buzz" result is divisible by 5.
* The ordinal position of every "FizzBuzz" is divisible by 15.


## Goals
### Traditional Imperative Style
I wanted to first accomplish this TDD Kata using a traditional imperative style, in Kotlin. 
This generally means a series of conditionals using Kotlin syntax such as:
```
fun fizzBuzz(number: Int): String {
    return when {
        number.rem(3) == 0 && number.rem(5) == 0 -> "FizzBuzz"	        
        number.rem(3) == 0 -> "Fizz"
        number.rem(5) == 0 -> "Buzz"
        else -> number.toString()
    }
}
```

### Tests
I ran across the above Truths and wanted to see if I could write better tests based on those.
The traditional scaffolding tests are a great start, but they should be refactored to better tests. This was an attempt at that.

### Refactored to Declarative Style
Then refactor to use a more declarative style. ***notice the lack of conditionals. 
```
private val fizzes = sequenceOf("", "", "Fizz").infinite()
private val buzzes = sequenceOf("", "", "", "", "Buzz").infinite()
private val numbers = generateSequence(1, Int::inc).infinite()
private val fizzBuzzes =
    fizzes
        .zip(buzzes, String::plus)
        .zip(numbers, wordOrNumber())

fun fizzBuzz(number: Int) = fizzBuzzes.take(number).toList()[number.minus(1)]
```
