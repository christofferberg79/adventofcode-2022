package cberg.aoc2022

import kotlin.math.abs
import kotlin.math.max

class Day15(private val input: List<String>) {
    fun part1(y: Int): Int {
        val data = parse(input)
        val ranges = data.mapValues { (s, b) -> s.distTo(b) }
            .filter { (s, d) -> abs(s.y - y) <= d }
            .map { (s, d) -> s.x - (d - abs(s.y - y))..s.x + (d - abs(s.y - y)) }

        var count = 0
        var max = Int.MIN_VALUE
        ranges.sortedBy { it.first }.forEach { range ->
            val start = max(max + 1, range.first)
            if (start <= range.last) {
                count += range.last - start + 1
                max = range.last
            }
        }

        return count - data.values.filter { it.y == y }.toSet().size
    }

    fun part2() = 0

    private data class Pos(val x: Int, val y: Int)

    private fun Pos.distTo(other: Pos) = abs(this.x - other.x) + abs(this.y - other.y)

    private val regex = Regex("Sensor at x=(.*), y=(.*): closest beacon is at x=(.*), y=(.*)")

    private fun parse(input: List<String>) = input.associate { line ->
        regex.matchEntire(line)?.destructured?.let { (sx, sy, bx, by) ->
            Pos(sx.toInt(), sy.toInt()) to Pos(bx.toInt(), by.toInt())
        } ?: error("invalid line: $line")
    }
}
