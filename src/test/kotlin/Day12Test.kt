package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day12Test {
    private val exampleInput = listOf(
        "Sabqponm",
        "abcryxxl",
        "accszExk",
        "acctuvwj",
        "abdefghi"
    )

    private val realInput = Input("day12.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day12(exampleInput).part1()
        assertEquals(31, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day12(realInput).part1()
        assertEquals(425, result)
    }

    @Test
    fun part2_Example() {
        val result = Day12(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day12(realInput).part2()
        assertEquals(0, result)
    }
}