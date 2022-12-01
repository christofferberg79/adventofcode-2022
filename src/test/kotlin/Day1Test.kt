package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day1Test {
    private val exampleInput = listOf(
        "1000",
        "2000",
        "3000",
        "",
        "4000",
        "",
        "5000",
        "6000",
        "",
        "7000",
        "8000",
        "9000",
        "",
        "10000"
    )

    private val realInput = Input("day1.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day1(exampleInput).part1()
        assertEquals(24000, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day1(realInput).part1()
        assertEquals(72478, result)
    }

    @Test
    fun part2_Example() {
        val result = Day1(exampleInput).part2()
        assertEquals(45000, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day1(realInput).part2()
        assertEquals(210367, result)
    }
}