package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day23Test {
    private val exampleInput = listOf(
        "....#..",
        "..###.#",
        "#...#.#",
        ".#...##",
        "#.###..",
        "##.#.##",
        ".#..#.."
    )

    private val smallExampleInput = listOf(
        ".....",
        "..##.",
        "..#..",
        ".....",
        "..##.",
        "....."
    )

    private val realInput = Input("day23.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day23(exampleInput).part1()
        assertEquals(110, result)
    }

    @Test
    fun part1_SmallExample() {
        val result = Day23(smallExampleInput).part1()
        assertEquals(25, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day23(realInput).part1()
        assertEquals(4025, result)
    }

    @Test
    fun part2_Example() {
        val result = Day23(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day23(realInput).part2()
        assertEquals(0, result)
    }
}