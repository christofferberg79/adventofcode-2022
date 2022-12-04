package cberg.aoc2022

class Day4(private val input: List<String>) {
    fun part1() = input.count { hasFullOverlap(it) }

    fun part2() = 0

    private fun hasFullOverlap(line: String) = line
        .split(",")
        .flatMap { it.split("-") }
        .map { it.toInt() }
        .let { (x1, x2, y1, y2) ->
            x1 <= y1 && x2 >= y2 || y1 <= x1 && y2 >= x2
        }
}
