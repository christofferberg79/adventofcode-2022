package cberg.aoc2022

class Day6(private val input: String) {
    fun part1() = input.windowed(4).indexOfFirst { it.toSet().size == 4 } + 4

    fun part2() = 0
}
