package cberg.aoc2022

import kotlin.math.min

class Day12(input: List<String>) {

    private val grid: List<List<Int>>
    private val target: Pos
    private val start: Pos

    init {
        lateinit var t: Pos
        lateinit var s: Pos
        grid = input.mapIndexed { y, line ->
            line.mapIndexed { x, c ->
                when (c) {
                    'S' -> {
                        s = Pos(x, y)
                        0
                    }

                    'E' -> {
                        t = Pos(x, y)
                        'z' - 'a'
                    }

                    else -> c - 'a'
                }
            }
        }
        target = t
        start = s
    }

    fun part1(): Int {
        val solved = mutableSetOf(start)
        val toCheck = start.adjacent().associateWith { 1 }.toMutableMap()

        while (toCheck.isNotEmpty()) {
            val (pos, steps) = toCheck.minBy { it.value }
            for (next in pos.adjacent() - solved) {
                if (next == target) {
                    return steps + 1
                }
                toCheck.merge(next, steps + 1) { a, b -> min(a, b) }
            }
            solved += pos
            toCheck.remove(pos)
        }
        error("no solution found")
    }

    fun part2() = 0

    private data class Pos(val x: Int, val y: Int)

    private fun Pos.adjacent() = listOf(Pos(x - 1, y), Pos(x + 1, y), Pos(x, y - 1), Pos(x, y + 1))
        .filter { p -> p.x in grid[0].indices && p.y in grid.indices && grid[p.y][p.x] <= grid[y][x] + 1 }
}
