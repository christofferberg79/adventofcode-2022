package cberg.aoc2022

class Day18(input: List<String>) {
    private val cubes = parse(input)

    fun part1(): Int {
        val xs = cubes.groupBy(keySelector = { Pair(it.y, it.z) }, valueTransform = { it.x }).values
        val ys = cubes.groupBy(keySelector = { Pair(it.x, it.z) }, valueTransform = { it.y }).values
        val zs = cubes.groupBy(keySelector = { Pair(it.x, it.y) }, valueTransform = { it.z }).values

        return surfaceArea(xs) + surfaceArea(ys) + surfaceArea(zs)
    }

    fun part2(): Int {
        val minX = cubes.minOf { it.x } - 1
        val maxX = cubes.maxOf { it.x } + 1
        val minY = cubes.minOf { it.y } - 1
        val maxY = cubes.maxOf { it.y } + 1
        val minZ = cubes.minOf { it.z } - 1
        val maxZ = cubes.maxOf { it.z } + 1

        val checked = mutableSetOf<Cube>()
        val toCheck = mutableSetOf(Cube(minX, minY, minZ))
        var count = 0

        while (toCheck.isNotEmpty()) {
            val cube = toCheck.first()
            toCheck.remove(cube)
            checked.add(cube)
            cube.adjacent()
                .filter { it.isIn(minX, maxX, minY, maxY, minZ, maxZ) && it !in checked }
                .forEach { if (it in cubes) count++ else toCheck.add(it) }
        }

        return count
    }

    private fun Cube.isIn(minX: Int, maxX: Int, minY: Int, maxY: Int, minZ: Int, maxZ: Int) =
        x in minX..maxX && y in minY..maxY && z in minZ..maxZ

    private fun Cube.adjacent() = listOf(
        Cube(x, y, z - 1),
        Cube(x, y, z + 1),
        Cube(x, y - 1, z),
        Cube(x, y + 1, z),
        Cube(x - 1, y, z),
        Cube(x + 1, y, z)
    )

    private fun parse(input: List<String>) = input
        .map { line -> line.split(",").map { it.toInt() } }
        .map { (x, y, z) -> Cube(x, y, z) }
        .toSet()

    private data class Cube(val x: Int, val y: Int, val z: Int)

    private fun surfaceArea(s: Collection<List<Int>>) = 2 * s.sumOf {
        1 + it.sorted().windowed(2).count { (x1, x2) -> x2 - x1 > 1 }
    }

}
