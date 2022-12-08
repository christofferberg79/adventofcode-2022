package cberg.aoc2022

class Day8(private val input: List<String>) {
    fun part1() = buildSet {
        val linesOfSight = leftToRight()
            .let { it + oppositeDirection(it) }
            .let { it + perpendicularDirection(it) }
        for (line in linesOfSight) {
            var highest = -1
            for (coord in line) {
                val height = input[coord.first][coord.second].digitToInt()
                if (height > highest) {
                    add(coord)
                    highest = height
                }
            }
        }
    }.size

    private fun leftToRight() = input.indices.map { y -> input[0].indices.map { x -> x to y } }

    private fun oppositeDirection(lines: List<List<Pair<Int, Int>>>) =
        lines.map { it.asReversed() }

    private fun perpendicularDirection(lines: List<List<Pair<Int, Int>>>) =
        lines.map { it.map { (x, y) -> y to x } }

    fun part2() = 0
}
