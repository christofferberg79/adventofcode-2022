package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day4Test {
    private val exampleInput = listOf(
        "2-4,6-8",
        "2-3,4-5",
        "5-7,7-9",
        "2-8,3-7",
        "6-6,4-6",
        "2-6,4-8"
    )

    private val realInput = Input("day4.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day4(exampleInput).part1()
        assertEquals(2, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day4(realInput).part1()
        assertEquals(466, result)
    }

    @Test
    fun part2_Example() {
        val result = Day4(exampleInput).part2()
        assertEquals(4, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day4(realInput).part2()
        assertEquals(865, result)
    }
}