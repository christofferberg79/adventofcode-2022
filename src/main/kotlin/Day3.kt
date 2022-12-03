package cberg.aoc2022

class Day3(private val input: List<String>) {
    fun part1() = input.sumOf { prio(it) }

    fun part2() = 0

    private fun prio(rucksack: String): Int {
        val (c1, c2) = rucksack.chunked(rucksack.length / 2)
        return prio(c1.first { it in c2 })
    }

    private fun prio(c: Char) = when (c) {
        in 'a'..'z' -> c - 'a' + 1
        else -> c - 'A' + 27
    }
}
