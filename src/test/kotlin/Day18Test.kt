package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day18Test {
    private val exampleInput = listOf(
        "2,2,2",
        "1,2,2",
        "3,2,2",
        "2,1,2",
        "2,3,2",
        "2,2,1",
        "2,2,3",
        "2,2,4",
        "2,2,6",
        "1,2,5",
        "3,2,5",
        "2,1,5",
        "2,3,5"
    )

    private val realInput = Input("day18.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day18(exampleInput).part1()
        assertEquals(64, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day18(realInput).part1()
        assertEquals(3470, result)
    }

    @Test
    fun part2_Example() {
        val result = Day18(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day18(realInput).part2()
        assertEquals(0, result)
    }
}