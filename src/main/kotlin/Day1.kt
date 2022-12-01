package cberg.aoc2022

class Day1(private val input: List<String>) {
    fun part1() = sums(input).max()

    fun part2() = sums(input).sorted().takeLast(3).sum()

    private fun sums(lines: List<String>): MutableList<Int> {
        val sums = mutableListOf(0)
        for (line in lines) {
            if (line.isEmpty()) {
                sums += 0
            } else {
                sums[sums.lastIndex] += line.toInt()
            }
        }
        return sums
    }
}
