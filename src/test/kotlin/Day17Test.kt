package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals


class Day17Test {
    private val exampleInput = ">>><<><>><<<>><>>><<<>>><<<><<<>><>><<>>"

    private val realInput = Input("day17.txt").oneLine()

    @Test
    fun part1_Example() {
        val result = Day17(exampleInput).part1()
        assertEquals(3068, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day17(realInput).part1()
        assertEquals(3081, result)
    }

    @Test
    fun part2_Example() {
        val result = Day17(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day17(realInput).part2()
        assertEquals(0, result)
    }
}