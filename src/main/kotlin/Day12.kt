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

    fun part1() = solve().getValue(start)

    fun part2(): Int {
        val solutions = solve()
        return startingPoints().mapNotNull { solutions[it] }.min()
    }

    private fun solve(): Map<Pos, Int> {
        val solved = mutableMapOf<Pos, Int>()
        val toCheck = mutableMapOf(target to 0)

        while (toCheck.isNotEmpty()) {
            val (pos, steps) = toCheck.minBy { it.value }
            for (next in pos.adjacent() - solved.keys) {
                toCheck.merge(next, steps + 1) { a, b -> min(a, b) }
            }
            solved[pos] = steps
            toCheck.remove(pos)
        }
        return solved
    }

    private data class Pos(val x: Int, val y: Int)

    private fun Pos.adjacent() = listOf(Pos(x - 1, y), Pos(x + 1, y), Pos(x, y - 1), Pos(x, y + 1))
        .filter { p -> p.x in grid[0].indices && p.y in grid.indices && grid[p.y][p.x] >= grid[y][x] - 1 }

    private fun startingPoints() = grid.indices.flatMap { y -> grid[y].indices.map { x -> Pos(x, y) } }
        .filter { (x, y) -> grid[y][x] == 0 }
}
