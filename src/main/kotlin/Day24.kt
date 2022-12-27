package cberg.aoc2022

class Day24(input: List<String>) {
    private val left = Pos(-1, 0)
    private val right = Pos(1, 0)
    private val up = Pos(0, -1)
    private val down = Pos(0, 1)

    private val xs = 1..(input[0].length - 2)
    private val ys = 1..(input.size - 2)

    private val start = Pos(1, 0)
    private val finish = Pos(xs.last, ys.last + 1)

    private var winds = parse(input)

    fun part1() = time(start, finish)

    fun part2() = time(start, finish) + time(finish, start) + time(start, finish)

    private fun time(from: Pos, to: Pos): Int {
        var time = 0
        var positions = setOf(from)
        while (to !in positions) {
            time++
            updateWinds()
            positions = newPositions(positions)
        }
        return time
    }

    private fun parse(input: List<String>) = ys.flatMap { y -> xs.map { x -> Pos(x, y) to input[y][x] } }
        .filter { (_, c) -> c != '.' }
        .map { (pos, c) -> pos to c.toDirection() }

    private fun Char.toDirection() = when (this) {
        '>' -> right
        '<' -> left
        '^' -> up
        'v' -> down
        else -> error("invalid direction: $this")
    }

    private fun updateWinds() {
        winds = winds.map { (pos, wind) -> wrapWind(pos + wind) to wind }
    }

    private fun wrapWind(pos: Pos) = Pos(wrap(pos.x, xs), wrap(pos.y, ys))

    private fun wrap(v: Int, range: IntRange) = when {
        v < range.first -> range.last
        v > range.last -> range.first
        else -> v
    }

    private fun newPositions(positions: Set<Pos>) =
        positions.flatMap { pos -> listOf(pos, pos + left, pos + right, pos + up, pos + down) }
            .filter { pos -> pos.inValley() }
            .toSet() - windPositions()

    private fun windPositions() = winds.map { it.first }.toSet()

    private fun Pos.inValley() = this == start || this == finish || x in xs && y in ys

    private data class Pos(val x: Int, val y: Int)

    private operator fun Pos.plus(other: Pos) = Pos(this.x + other.x, this.y + other.y)
}
