package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day2Test {
    private val exampleInput = listOf(
        "A Y",
        "B X",
        "C Z"
    )

    private val realInput = Input("day2.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day2(exampleInput).part1()
        assertEquals(15, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day2(realInput).part1()
        assertEquals(9177, result)
    }

    @Test
    fun part2_Example() {
        val result = Day2(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day2(realInput).part2()
        assertEquals(0, result)
    }
}