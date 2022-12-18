package cberg.aoc2022

import kotlin.math.max

class Day17(private val input: String) {
    private val rocks = listOf(
        listOf(Pos(0, 0), Pos(1, 0), Pos(2, 0), Pos(3, 0)),
        listOf(Pos(1, 0), Pos(0, 1), Pos(1, 1), Pos(2, 1), Pos(1, 2)),
        listOf(Pos(0, 0), Pos(1, 0), Pos(2, 0), Pos(2, 1), Pos(2, 2)),
        listOf(Pos(0, 0), Pos(0, 1), Pos(0, 2), Pos(0, 3)),
        listOf(Pos(0, 0), Pos(1, 0), Pos(0, 1), Pos(1, 1)),
    )

    fun part1(): Int {
        var nextRock = 0
        var nextJet = 0
        val stoppedRocks = mutableSetOf<Pos>()
        var towerHeight = 0
        repeat(2022) {

            val rock = rocks[nextRock]
            nextRock = (nextRock + 1) % rocks.size

            var offset = Pos(3, towerHeight + 4)

            while (true) {
                val jet = input[nextJet]
                nextJet = (nextJet + 1) % input.length
                val jetOffset = if (jet == '<') Pos(offset.x - 1, offset.y) else Pos(offset.x + 1, offset.y)
                if (rock.map { it + jetOffset }.none { it.x < 1 || it.x > 7 || it in stoppedRocks }) {
                    offset = jetOffset
                }

                val fallOffset = Pos(offset.x, offset.y - 1)
                if (rock.map { it + fallOffset }.any { it.y < 1 || it in stoppedRocks }) {
                    val stoppedRock = rock.map { it + offset }
                    stoppedRocks += stoppedRock
                    towerHeight = max(towerHeight, stoppedRock.maxOf { it.y })
                    break
                } else {
                    offset = fallOffset
                }
            }
        }
        return towerHeight
    }

    fun part2() = 0

    private data class Pos(val x: Int, val y: Int)

    private operator fun Pos.plus(other: Pos) = Pos(this.x + other.x, this.y + other.y)
}
