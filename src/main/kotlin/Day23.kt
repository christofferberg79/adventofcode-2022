package cberg.aoc2022

class Day23(private val input: List<String>) {

    fun part1(): Int {
        val directions = mutableListOf(
            listOf(N, NE, NW) to N,
            listOf(S, SE, SW) to S,
            listOf(W, NW, SW) to W,
            listOf(E, NE, SE) to E
        )
        var state = parse(input).toSet()
        repeat(10) {
            val proposedMoves = proposedMoves(state, directions)
            val collisions = proposedMoves.groupingBy { it.second }.eachCount().filterValues { it > 1 }.keys
            state = proposedMoves.map { (pos, newPos) -> if (newPos in collisions) pos else newPos }.toSet()
            directions.add(directions.removeFirst())
        }

        return emptyTiles(state)
    }

    fun part2() = 0

    private fun parse(input: List<String>) =
        input.flatMapIndexed { y: Int, line: String ->
            line.mapIndexed { x, c -> x to c }.filter { (_, c) -> c == '#' }.map { (x, _) -> Pos(x, y) }
        }

    private fun proposedMoves(state: Set<Pos>, directions: List<Pair<List<Pos>, Pos>>): List<Pair<Pos, Pos>> {
        return state.map { pos ->
            val newPos = if (pos.allAdjacent().none { it in state }) {
                pos
            } else {
                directions.firstOrNull { (looks, _) -> looks.none { pos + it in state } }
                    ?.let { (_, move) -> pos + move }
                    ?: pos
            }
            pos to newPos
        }
    }

    private data class Pos(val x: Int, val y: Int)

    private operator fun Pos.plus(other: Pos) = Pos(this.x + other.x, this.y + other.y)

    private val N = Pos(0, -1)
    private val E = Pos(1, 0)
    private val S = Pos(0, 1)
    private val W = Pos(-1, 0)
    private val NE = N + E
    private val NW = N + W
    private val SE = S + E
    private val SW = S + W
    private fun Pos.allAdjacent() = listOf(N, E, S, W, NE, NW, SE, SW).map { this + it }

    private fun emptyTiles(state: Set<Pos>): Int {
        val minX = state.minOf(Pos::x)
        val maxX = state.maxOf(Pos::x)
        val minY = state.minOf(Pos::y)
        val maxY = state.maxOf(Pos::y)
        return (maxX - minX + 1) * (maxY - minY + 1) - state.size
    }
}
