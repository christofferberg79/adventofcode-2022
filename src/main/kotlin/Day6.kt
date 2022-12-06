package cberg.aoc2022

class Day6(private val input: String) {
    fun part1() = solve(4)

    fun part2() = solve(14)

    private fun solve(n: Int) = input.windowed(n).indexOfFirst { it.toSet().size == n } + n
}
