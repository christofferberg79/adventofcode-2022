package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day8Test {
    private val exampleInput = listOf(
        "30373",
        "25512",
        "65332",
        "33549",
        "35390"
    )

    private val realInput = Input("day8.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day8(exampleInput).part1()
        assertEquals(21, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day8(realInput).part1()
        assertEquals(1703, result)
    }

    @Test
    fun part2_Example() {
        val result = Day8(exampleInput).part2()
        assertEquals(8, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day8(realInput).part2()
        assertEquals(496650, result)
    }
}