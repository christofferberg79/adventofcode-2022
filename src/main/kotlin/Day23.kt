package cberg.aoc2022

class Day23(input: List<String>) {
    private val N = Pos(0, -1)
    private val E = Pos(1, 0)
    private val S = Pos(0, 1)
    private val W = Pos(-1, 0)
    private val NE = N + E
    private val NW = N + W
    private val SE = S + E
    private val SW = S + W

    private var state = parse(input)
    private val directions = mutableListOf(
        listOf(N, NE, NW) to N,
        listOf(S, SE, SW) to S,
        listOf(W, NW, SW) to W,
        listOf(E, NE, SE) to E
    )

    fun part1(): Int {
        repeat(10) {
            updateState(proposedMoves())
        }
        return emptyTiles()
    }

    fun part2(): Int {
        var rounds = 1
        while (true) {
            val proposedMoves = proposedMoves()
            if (proposedMoves.isEmpty()) {
                return rounds
            }
            updateState(proposedMoves)
            rounds++
        }
    }

    private fun updateState(proposedMoves: Map<Pos, Pos>) {
        state = move(proposedMoves)
        directions.add(directions.removeFirst())
    }

    private fun parse(input: List<String>) = input.flatMapIndexed { y: Int, line: String ->
        line.mapIndexed { x, c -> x to c }.filter { (_, c) -> c == '#' }.map { (x, _) -> Pos(x, y) }
    }.toSet()

    private fun proposedMoves() =
        state.associateWith { pos ->
            val newPos = if (pos.allAdjacent().none { it in state }) {
                pos
            } else {
                directions.firstOrNull { (looks, _) -> looks.none { pos + it in state } }
                    ?.let { (_, move) -> pos + move }
                    ?: pos
            }
            newPos
        }.filter { (pos, newPos) -> pos != newPos }

    private fun move(proposedMoves: Map<Pos, Pos>): Set<Pos> {
        val collisions = proposedMoves.values.groupingBy { it }.eachCount().filterValues { it > 1 }.keys
        return state.map { pos -> proposedMoves.getOrDefault(pos, pos).let { if (it in collisions) pos else it } }
            .toSet()
    }

    private data class Pos(val x: Int, val y: Int)

    private operator fun Pos.plus(other: Pos) = Pos(this.x + other.x, this.y + other.y)

    private fun Pos.allAdjacent() = listOf(N, E, S, W, NE, NW, SE, SW).map { this + it }

    private fun emptyTiles(): Int {
        val minX = state.minOf(Pos::x)
        val maxX = state.maxOf(Pos::x)
        val minY = state.minOf(Pos::y)
        val maxY = state.maxOf(Pos::y)
        return (maxX - minX + 1) * (maxY - minY + 1) - state.size
    }
}
