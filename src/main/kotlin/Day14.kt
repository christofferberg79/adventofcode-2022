package cberg.aoc2022

class Day14(private val input: List<String>) {
    fun part1(): Int {
        val occupied = getRocks().toMutableSet()
        val maxY = occupied.maxOf { it.y }

        var count = 0
        while (true) {
            var sandPos = Pos(500, 0)
            while (true) {
                val toCheck = listOf(0, -1, 1).map { dx -> Pos(sandPos.x + dx, sandPos.y + 1) }
                val nextPos = toCheck.firstOrNull { it !in occupied }
                if (nextPos == null) {
                    occupied += sandPos
                    count++
                    break
                } else if (nextPos.y >= maxY) {
                    return count
                } else {
                    sandPos = nextPos
                }
            }
        }
    }

    private fun getRocks() = input
        .flatMap { line ->
            line.split(" -> ")
                .map { xy -> xy.split(",").let { (x, y) -> Pos(x.toInt(), y.toInt()) } }
                .windowed(2)
                .flatMap { (p1, p2) -> pointsOnLine(p1, p2) }
        }
        .toSet()

    private fun pointsOnLine(p1: Pos, p2: Pos): List<Pos> {
        val xs = if (p1.x < p2.x) p1.x..p2.x else p2.x..p1.x
        val ys = if (p1.y < p2.y) p1.y..p2.y else p2.y..p1.y
        return xs.flatMap { x -> ys.map { y -> Pos(x, y) } }
    }

    fun part2() = 0

    private data class Pos(val x: Int, val y: Int)
}
