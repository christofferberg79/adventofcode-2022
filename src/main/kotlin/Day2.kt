package cberg.aoc2022

class Day2(private val input: List<String>) {
    private val shapeScores = mapOf(
        "A" to 1,
        "B" to 2,
        "C" to 3,
        "X" to 1,
        "Y" to 2,
        "Z" to 3
    )

    fun part1() = input.sumOf { score(it) }

    fun part2() = input.sumOf { score2(it) }

    private fun score(round: String): Int {
        val (s1, s2) = parse(round)
        return when(s2) {
            s1 -> s2 + 3
            s1 % 3 + 1 -> s2 + 6
            else -> s2
        }
    }

    private fun score2(round: String): Int {
        val (s1, s2) = parse(round)
        return when (s2) {
            1 -> (s1 + 1) % 3 + 1
            2 -> 3 + s1
            else -> 6 + s1 % 3 + 1
        }
    }

    private fun parse(round: String) = round.split(" ").map { shapeScores.getValue(it) }
}
