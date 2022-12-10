package cberg.aoc2022

class Day10(private val input: List<String>) {
    private var cycle = 0
    private var x = 1
    private var sum = 0

    fun part1(): Int {
        for (line in input) {
            tick()
            if (line != "noop") {
                tick()
                x += line.split(" ").last().toInt()
            }
        }
        return sum
    }

    fun part2() = 0

    private fun tick() {
        if (++cycle in 20..220 step 40) {
            sum += cycle * x
        }
    }
}
