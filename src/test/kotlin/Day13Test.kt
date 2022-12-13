package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day13Test {
    private val exampleInput = listOf(
        "[1,1,3,1,1]",
        "[1,1,5,1,1]",
        "",
        "[[1],[2,3,4]]",
        "[[1],4]",
        "",
        "[9]",
        "[[8,7,6]]",
        "",
        "[[4,4],4,4]",
        "[[4,4],4,4,4]",
        "",
        "[7,7,7,7]",
        "[7,7,7]",
        "",
        "[]",
        "[3]",
        "",
        "[[[]]]",
        "[[]]",
        "",
        "[1,[2,[3,[4,[5,6,7]]]],8,9]",
        "[1,[2,[3,[4,[5,6,0]]]],8,9]"
    )

    private val realInput = Input("day13.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day13(exampleInput).part1()
        assertEquals(13, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day13(realInput).part1()
        assertEquals(6395, result)
    }

    @Test
    fun part2_Example() {
        val result = Day13(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day13(realInput).part2()
        assertEquals(0, result)
    }
}