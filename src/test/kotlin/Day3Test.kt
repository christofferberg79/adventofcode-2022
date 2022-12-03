package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day3Test {
    private val exampleInput = listOf(
        "vJrwpWtwJgWrhcsFMMfFFhFp",
        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
        "PmmdzqPrVvPwwTWBwg",
        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
        "ttgJtRGJQctTZtZT",
        "CrZsJsPPZsGzwwsLwLmpwMDw"
    )

    private val realInput = Input("day3.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day3(exampleInput).part1()
        assertEquals(157, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day3(realInput).part1()
        assertEquals(7997, result)
    }

    @Test
    fun part2_Example() {
        val result = Day3(exampleInput).part2()
        assertEquals(70, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day3(realInput).part2()
        assertEquals(2545, result)
    }
}