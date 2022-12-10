package cberg.aoc2022

import kotlin.math.abs

class Day10(private val input: List<String>) {
    private var cycle = 0
    private var x = 1

    fun part1(): Int {
        var sum = 0
        execute {
            if (++cycle in 20..220 step 40) {
                sum += cycle * x
            }
        }
        return sum
    }

    fun part2(): List<String> {
        val image = mutableListOf("")
        execute {
            val output = if (abs(cycle++ % 40 - x) <= 1) "#" else "."
            if (image.last().length == 40) {
                image.add(output)
            } else {
                image.add(image.removeLast() + output)
            }
        }
        return image
    }

    private fun execute(tick: () -> Unit) {
        for (line in input) {
            tick()
            if (line != "noop") {
                tick()
                x += line.split(" ").last().toInt()
            }
        }
    }

}
