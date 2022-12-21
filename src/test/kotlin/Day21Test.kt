package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day21Test {
    private val exampleInput = listOf(
        "root: pppw + sjmn",
        "dbpl: 5",
        "cczh: sllz + lgvd",
        "zczc: 2",
        "ptdq: humn - dvpt",
        "dvpt: 3",
        "lfqf: 4",
        "humn: 5",
        "ljgn: 2",
        "sjmn: drzm * dbpl",
        "sllz: 4",
        "pppw: cczh / lfqf",
        "lgvd: ljgn * ptdq",
        "drzm: hmdt - zczc",
        "hmdt: 32"
    )

    private val realInput = Input("day21.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day21(exampleInput).part1()
        assertEquals(152, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day21(realInput).part1()
        assertEquals(223971851179174, result)
    }

    @Test
    fun part2_Example() {
        val result = Day21(exampleInput).part2()
        assertEquals(0, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day21(realInput).part2()
        assertEquals(0, result)
    }
}