package cberg.aoc2022

class Day18(private val input: List<String>) {
    fun part1(): Int {
        val cubes = input.map { line -> line.split(",").map { it.toInt() } }.map { (x, y, z) -> Cube(x, y, z) }
        val xs = cubes.groupBy(keySelector = { Pair(it.y, it.z) }, valueTransform = { it.x }).values
        val ys = cubes.groupBy(keySelector = { Pair(it.x, it.z) }, valueTransform = { it.y }).values
        val zs = cubes.groupBy(keySelector = { Pair(it.x, it.y) }, valueTransform = { it.z }).values

        return surfaceArea(xs) + surfaceArea(ys) + surfaceArea(zs)
    }

    fun part2() = 0

    private data class Cube(val x: Int, val y: Int, val z: Int)

    private fun surfaceArea(s: Collection<List<Int>>) = 2 * s.sumOf {
        1 + it.sorted().windowed(2).count { (x1, x2) -> x2 - x1 > 1 }
    }

}
