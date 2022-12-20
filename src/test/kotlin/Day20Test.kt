package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day20Test {
    private val exampleInput = listOf(1, 2, -3, 3, -2, 0, 4)

    private val realInput = Input("day20.txt").intLines()

    @Test
    fun part1_Example() {
        val result = Day20(exampleInput).part1()
        assertEquals(3, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day20(realInput).part1()
        assertEquals(18257, result)
    }

    @Test
    fun part2_Example() {
        val result = Day20(exampleInput).part2()
        assertEquals(1623178306, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day20(realInput).part2()
        assertEquals(4148032160983, result)
    }
}