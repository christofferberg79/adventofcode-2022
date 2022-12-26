package cberg.aoc2022

import cberg.aoc2022.Day25.Companion.decimalToSnafu
import cberg.aoc2022.Day25.Companion.snafuToDecimal
import kotlin.test.Test
import kotlin.test.assertEquals

class Day25Test {
    private val exampleInput = listOf(
        "1=-0-2",
        "12111",
        "2=0=",
        "21",
        "2=01",
        "111",
        "20012",
        "112",
        "1=-1=",
        "1-12",
        "12",
        "1=",
        "122"
    )

    private val decimalAndSnafu = listOf(
        1L to "1",
        2L to "2",
        3L to "1=",
        4L to "1-",
        5L to "10",
        6L to "11",
        7L to "12",
        8L to "2=",
        9L to "2-",
        10L to "20",
        15L to "1=0",
        20L to "1-0",
        2022L to "1=11-2",
        12345L to "1-0---0",
        314159265L to "1121-1110-1=0"
    )

    private val realInput = Input("day25.txt").lines()

    @Test
    fun testSnafuToDecimal() {
        for ((decimal, snafu) in decimalAndSnafu) {
            assertEquals(decimal, snafuToDecimal(snafu))
        }
    }

    @Test
    fun testDecimalToSnafu() {
        for ((decimal, snafu) in decimalAndSnafu) {
            assertEquals(snafu, decimalToSnafu(decimal))
        }
    }

    @Test
    fun part1_Example() {
        val result = Day25(exampleInput).part1()
        assertEquals("2=-1=0", result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day25(realInput).part1()
        assertEquals("20-=0=02=-21=00-02=2", result)
    }

    @Test
    fun part2_Example() {
        val result = Day25(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day25(realInput).part2()
        assertEquals(0, result)
    }
}