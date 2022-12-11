package cberg.aoc2022

import cberg.aoc2022.Day11.Monkey
import kotlin.test.Test
import kotlin.test.assertEquals

class Day11Test {
    private val exampleInput = listOf(
        Monkey(
            items = mutableListOf(79, 98),
            op = { it * 19 },
            div = 23,
            ifTrue = 2,
            ifFalse = 3
        ),
        Monkey(
            items = mutableListOf(54, 65, 75, 74),
            op = { it + 6 },
            div = 19,
            ifTrue = 2,
            ifFalse = 0
        ),
        Monkey(
            items = mutableListOf(79, 60, 97),
            op = { it * it },
            div = 13,
            ifTrue = 1,
            ifFalse = 3
        ),
        Monkey(
            items = mutableListOf(74),
            op = { it + 3 },
            div = 17,
            ifTrue = 0,
            ifFalse = 1
        )
    )

    private val realInput = listOf(
        Monkey(
            items = mutableListOf(96, 60, 68, 91, 83, 57, 85),
            op = { it * 2 },
            div = 17,
            ifTrue = 2,
            ifFalse = 5
        ),
        Monkey(
            items = mutableListOf(75, 78, 68, 81, 73, 99),
            op = { it + 3 },
            div = 13,
            ifTrue = 7,
            ifFalse = 4
        ),
        Monkey(
            items = mutableListOf(69, 86, 67, 55, 96, 69, 94, 85),
            op = { it + 6 },
            div = 19,
            ifTrue = 6,
            ifFalse = 5
        ),
        Monkey(
            items = mutableListOf(88, 75, 74, 98, 80),
            op = { it + 5 },
            div = 7,
            ifTrue = 7,
            ifFalse = 1
        ),
        Monkey(
            items = mutableListOf(82),
            op = { it + 8 },
            div = 11,
            ifTrue = 0,
            ifFalse = 2
        ),
        Monkey(
            items = mutableListOf(72, 92, 92),
            op = { it * 5 },
            div = 3,
            ifTrue = 6,
            ifFalse = 3
        ),
        Monkey(
            items = mutableListOf(74, 61),
            op = { it * it },
            div = 2,
            ifTrue = 3,
            ifFalse = 1
        ),
        Monkey(
            items = mutableListOf(76, 86, 83, 55),
            op = { it + 4 },
            div = 5,
            ifTrue = 4,
            ifFalse = 0
        )

    )

    @Test
    fun part1_Example() {
        val result = Day11(exampleInput).part1()
        assertEquals(10605, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day11(realInput).part1()
        assertEquals(56595, result)
    }

    @Test
    fun part2_Example() {
        val result = Day11(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day11(realInput).part2()
        assertEquals(0, result)
    }
}