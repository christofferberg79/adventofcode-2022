package cberg.aoc2022

class Day5(input: List<String>) {
    private val stacks = parseCrates(input.takeWhile(String::isNotBlank))
    private val moves = parseMoves(input.dropWhile(String::isNotBlank).dropWhile(String::isBlank))

    fun part1(): String {
        for ((num, from, to) in moves) {
            repeat(num) {
                stacks[to]!! += stacks[from]!!.removeLast()
            }
        }
        return topCratesAsString()
    }

    fun part2(): String {
        for ((num, from, to) in moves) {
            stacks[to]!! += stacks[from]!!.takeLast(num)
            repeat(num) {
                stacks[from]!!.removeLast()
            }
        }
        return topCratesAsString()
    }

    private fun parseCrates(input: List<String>) =
        input.last().mapIndexed { i, c -> c to i }.filter { (c, _) -> c.isDigit() }
            .associate { (c, i) ->
                c.digitToInt() to input.asReversed().drop(1).map { it[i] }.filter(Char::isLetter).toMutableList()
            }

    private fun parseMoves(input: List<String>) = input.map { line ->
        line.split(" ").mapNotNull(String::toIntOrNull)
    }

    private fun topCratesAsString() = stacks.values.map { it.last() }.joinToString("")
}
