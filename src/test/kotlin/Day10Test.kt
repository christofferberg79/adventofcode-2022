package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day10Test {
    private val exampleInput = Input("day10_example.txt").lines()

    private val realInput = Input("day10.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day10(exampleInput).part1()
        assertEquals(13140, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day10(realInput).part1()
        assertEquals(13220, result)
    }

    @Test
    fun part2_Example() {
        val result = Day10(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day10(realInput).part2()
        assertEquals(0, result)
    }
}