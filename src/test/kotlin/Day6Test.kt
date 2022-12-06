package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day6Test {
    private val exampleInput = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"

    private val realInput = Input("day6.txt").oneLine()

    @Test
    fun part1_Example() {
        val result = Day6(exampleInput).part1()
        assertEquals(7, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day6(realInput).part1()
        assertEquals(1300, result)
    }

    @Test
    fun part2_Example() {
        val result = Day6(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day6(realInput).part2()
        assertEquals(0, result)
    }
}