package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day14Test {
    private val exampleInput = listOf(
        "498,4 -> 498,6 -> 496,6",
        "503,4 -> 502,4 -> 502,9 -> 494,9"
    )

    private val realInput = Input("day14.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day14(exampleInput).part1()
        assertEquals(24, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day14(realInput).part1()
        assertEquals(737, result)
    }

    @Test
    fun part2_Example() {
        val result = Day14(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day14(realInput).part2()
        assertEquals(0, result)
    }
}