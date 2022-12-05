package cberg.aoc2022

class Day5(private val input: List<String>) {
    fun part1(): String {
        val stacks = parseCrates(input.takeWhile(String::isNotBlank))
        val moves = parseMoves(input.dropWhile(String::isNotBlank).dropWhile(String::isBlank))
        for ((num, from, to) in moves) {
            repeat(num) {
                stacks[to]!! += stacks[from]!!.removeLast()
            }
        }
        return stacks.values.map { it.last() }.joinToString("")
    }

    fun part2() = 0

    private fun parseCrates(input: List<String>) =
        input.last().mapIndexed { i, c -> c to i }.filter { (c, _) -> c.isDigit() }
            .associate { (c, i) ->
                c.digitToInt() to input.asReversed().drop(1).map { it[i] }.filter { it != ' ' }.toMutableList()
            }

    private fun parseMoves(input: List<String>) = input.map { line ->
        line.split(Regex("\\D+")).filter(String::isNotEmpty).map(String::toInt)
    }
}
