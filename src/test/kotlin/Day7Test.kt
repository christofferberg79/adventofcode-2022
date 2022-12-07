package cberg.aoc2022

import kotlin.test.Test
import kotlin.test.assertEquals

class Day7Test {
    private val exampleInput = listOf(
        "\$ cd /",
        "\$ ls",
        "dir a",
        "14848514 b.txt",
        "8504156 c.dat",
        "dir d",
        "\$ cd a",
        "\$ ls",
        "dir e",
        "29116 f",
        "2557 g",
        "62596 h.lst",
        "\$ cd e",
        "\$ ls",
        "584 i",
        "\$ cd ..",
        "\$ cd ..",
        "\$ cd d",
        "\$ ls",
        "4060174 j",
        "8033020 d.log",
        "5626152 d.ext",
        "7214296 k"
    )

    private val realInput = Input("day7.txt").lines()

    @Test
    fun part1_Example() {
        val result = Day7(exampleInput).part1()
        assertEquals(95437, result)
    }

    @Test
    fun part1_RealInput() {
        val result = Day7(realInput).part1()
        assertEquals(1206825, result)
    }

    @Test
    fun part2_Example() {
        val result = Day7(exampleInput).part2()
        assertEquals(24933642, result)
    }

    @Test
    fun part2_RealInput() {
        val result = Day7(realInput).part2()
        assertEquals(9608311, result)
    }
}