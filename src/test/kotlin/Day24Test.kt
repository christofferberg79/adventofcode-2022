package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day24Test {
    private val exampleInput = listOf(
        "#.######",
        "#>>.<^<#",
        "#.<..<<#",
        "#>v.><>#",
        "#<^v^^>#",
        "######.#"
    )

    private val realInput = Input("day24.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day24(exampleInput).part1()
        assertEquals(18, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day24(realInput).part1()
        assertEquals(253, result)
    }

    @Test
    fun part2_Example() {
        val result = Day24(exampleInput).part2()
        assertEquals(54, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day24(realInput).part2()
        assertEquals(794, result)
    }
}