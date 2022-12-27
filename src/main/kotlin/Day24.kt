package cberg.aoc2022

class Day24(private val input: List<String>) {
    private val xs = 1..(input[0].length - 2)
    private val ys = 1..(input.size - 2)
    private val start = Pos(1, 0)
    private val finish = Pos(xs.last, ys.last + 1)

    fun part1(): Int {
        var time = 0
        var positions = setOf(start)
        var winds = parse(input)
        while (finish !in positions) {
            time++
            winds = newWinds(winds)
            positions = newPositions(positions, winds)
        }
        return time
    }

    fun part2() = 0

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

    private fun newWinds(winds: List<Pair<Pos, Pos>>) = winds.map { (pos, wind) ->
        wrapWind(pos + wind) to wind
    }

    private fun wrapWind(pos: Pos) = when {
        pos.x > xs.last -> Pos(xs.first, pos.y)
        pos.x < xs.first -> Pos(xs.last, pos.y)
        pos.y > ys.last -> Pos(pos.x, ys.first)
        pos.y < ys.first -> Pos(pos.x, ys.last)
        else -> pos
    }

    private fun newPositions(positions: Set<Pos>, winds: List<Pair<Pos, Pos>>): Set<Pos> {
        val windPositions = winds.map { it.first }.toSet()
        return positions.flatMap { pos -> listOf(pos, pos + left, pos + right, pos + up, pos + down) }
            .filterNot { pos -> pos in windPositions }
            .filter { pos -> pos.inValley() }
            .toSet()
    }

    private fun Pos.inValley() = this == start || this == finish || x in xs && y in ys

    private data class Pos(val x: Int, val y: Int)

    private operator fun Pos.plus(other: Pos) = Pos(this.x + other.x, this.y + other.y)
    private val left = Pos(-1, 0)
    private val right = start
    private val up = Pos(0, -1)
    private val down = Pos(0, 1)
}
