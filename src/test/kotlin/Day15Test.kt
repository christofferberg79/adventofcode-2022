package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day15Test {
    private val exampleInput = listOf(
        "Sensor at x=2, y=18: closest beacon is at x=-2, y=15",
        "Sensor at x=9, y=16: closest beacon is at x=10, y=16",
        "Sensor at x=13, y=2: closest beacon is at x=15, y=3",
        "Sensor at x=12, y=14: closest beacon is at x=10, y=16",
        "Sensor at x=10, y=20: closest beacon is at x=10, y=16",
        "Sensor at x=14, y=17: closest beacon is at x=10, y=16",
        "Sensor at x=8, y=7: closest beacon is at x=2, y=10",
        "Sensor at x=2, y=0: closest beacon is at x=2, y=10",
        "Sensor at x=0, y=11: closest beacon is at x=2, y=10",
        "Sensor at x=20, y=14: closest beacon is at x=25, y=17",
        "Sensor at x=17, y=20: closest beacon is at x=21, y=22",
        "Sensor at x=16, y=7: closest beacon is at x=15, y=3",
        "Sensor at x=14, y=3: closest beacon is at x=15, y=3",
        "Sensor at x=20, y=1: closest beacon is at x=15, y=3"
    )

    private val realInput = Input("day15.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day15(exampleInput).part1(10)
        assertEquals(26, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day15(realInput).part1(2000000)
        assertEquals(5144286, result)
    }

    @Test
    fun part2_Example() {
        val result = Day15(exampleInput).part2(20)
        assertEquals(56000011, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day15(realInput).part2(4000000)
        assertEquals(10229191267339, result)
    }
}