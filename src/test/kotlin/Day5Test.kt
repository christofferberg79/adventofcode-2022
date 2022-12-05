package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day5Test {
    private val exampleInput = listOf(
        "    [D]    ",
        "[N] [C]    ",
        "[Z] [M] [P]",
        " 1   2   3 ",
        "",
        "move 1 from 2 to 1",
        "move 3 from 1 to 3",
        "move 2 from 2 to 1",
        "move 1 from 1 to 2"
    )

    private val realInput = Input("day5.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day5(exampleInput).part1()
        assertEquals("CMZ", result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day5(realInput).part1()
        assertEquals("RTGWZTHLD", result)
    }

    @Test
    fun part2_Example() {
        val result = Day5(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day5(realInput).part2()
        assertEquals(0, result)
    }
}