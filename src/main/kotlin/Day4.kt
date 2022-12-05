package cberg.aoc2022

class Day4(private val input: List<String>) {
    fun part1() = input.count(::hasFullOverlap)

    fun part2() = input.count(::hasSomeOverlap)

    private fun hasFullOverlap(line: String) = parse(line).let { (x1, x2, y1, y2) ->
        x1 <= y1 && x2 >= y2 || y1 <= x1 && y2 >= x2
    }

    private fun hasSomeOverlap(line: String) = parse(line).let { (x1, x2, y1, y2) ->
        x1 <= y2 && x2 >= y1
    }

    private fun parse(line: String) = line
        .split(Regex("[,-]"))
        .map(String::toInt)
}
