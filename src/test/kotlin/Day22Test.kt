package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day22Test {
    private val exampleInput = listOf(
        "        ...#",
        "        .#..",
        "        #...",
        "        ....",
        "...#.......#",
        "........#...",
        "..#....#....",
        "..........#.",
        "        ...#....",
        "        .....#..",
        "        .#......",
        "        ......#.",
        "",
        "10R5L5R10L4R5L5"
    )

    private val realInput = Input("day22.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day22(exampleInput).part1()
        assertEquals(6032, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day22(realInput).part1()
        assertEquals(189140, result)
    }

    @Test
    fun part2_Example() {
        val result = Day22(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day22(realInput).part2()
        assertEquals(0, result)
    }
}