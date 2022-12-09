package cberg.aoc2022

import kotlin.math.abs

class Day9(private val input: List<String>) {
    fun part1() = solve(MutableList(2) { Vec(0, 0) })

    fun part2() = solve(MutableList(10) { Vec(0, 0) })

    private fun solve(knots: MutableList<Vec>) = buildSet {
        parse(input).forEach { (dir, dist) ->
            repeat(dist) {
                knots[0] = moveHead(knots[0], dir)
                knots.indices.windowed(2).forEach { (i1, i2) ->
                    knots[i2] = moveNext(knots[i1], knots[i2])
                }
                add(knots.last())
            }
        }
    }.size

    private fun parse(input: List<String>) = input.map { it.split(" ") }
        .map { (a, b) -> a.single() to b.toInt() }

    private fun moveHead(h: Vec, dir: Char) = when (dir) {
        'R' -> h.right()
        'L' -> h.left()
        'U' -> h.up()
        'D' -> h.down()
        else -> error("Invalid direction: $dir")
    }

    private fun moveNext(h: Vec, t: Vec) = t + calcMove(h - t)

    private fun calcMove(d: Vec) = if (abs(d.x) > 1 || abs(d.y) > 1) {
        d.coerceIn(-1..1)
    } else {
        Vec(0, 0)
    }

    private data class Vec(val x: Int, val y: Int)

    private operator fun Vec.plus(other: Vec) = Vec(this.x + other.x, this.y + other.y)
    private operator fun Vec.minus(other: Vec) = Vec(this.x - other.x, this.y - other.y)
    private fun Vec.left() = Vec(x - 1, y)
    private fun Vec.right() = Vec(x + 1, y)
    private fun Vec.up() = Vec(x, y + 1)
    private fun Vec.down() = Vec(x, y - 1)
    private fun Vec.coerceIn(range: ClosedRange<Int>) = Vec(x.coerceIn(range), y.coerceIn(range))
}
