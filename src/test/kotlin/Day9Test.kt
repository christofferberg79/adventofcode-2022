package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day9Test {
    private val exampleInput = listOf(
        "R 4",
        "U 4",
        "L 3",
        "D 1",
        "R 4",
        "D 1",
        "L 5",
        "R 2"
    )

    private val realInput = Input("day9.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day9(exampleInput).part1()
        assertEquals(13, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day9(realInput).part1()
        assertEquals(5981, result)
    }

    @Test
    fun part2_Example() {
        val result = Day9(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day9(realInput).part2()
        assertEquals(0, result)
    }
}