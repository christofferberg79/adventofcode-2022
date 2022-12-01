package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class DayXTest {
    private val exampleInput = listOf(
        ""
    )

    private val realInput = Input("dayX.txt").lines()

    @Test
    fun part1_Example() {
        val result = DayX(exampleInput).part1()
        assertEquals(0, result)
    }

    @Test
    fun part1_RealInput() {
        val result = DayX(realInput).part1()
        assertEquals(0, result)
    }

    @Test
    fun part2_Example() {
        val result = DayX(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = DayX(realInput).part2()
        assertEquals(0, result)
    }
}