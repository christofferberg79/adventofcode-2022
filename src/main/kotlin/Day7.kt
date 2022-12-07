package cberg.aoc2022

class Day7(input: List<String>) {
    private val dirs = mutableSetOf("/")
    private val files = mutableMapOf<String, Int>()

    init {
        investigateFileSystem(input)
    }

    fun part1() = dirSizes().filter { it <= 100000 }.sum()

    fun part2() = dirSizes().filter { it >= files.values.sum() - 40000000 }.min()

    private fun dirSizes() = dirs.map { dir -> files.filterKeys { name -> name.startsWith(dir) }.values.sum() }

    private fun investigateFileSystem(input: List<String>) {
        var currentDir = "/"
        for (line in input) {
            if (line.startsWith("$ cd ")) {
                currentDir = when (val dir = line.split(" ")[2]) {
                    "/" -> dir
                    ".." -> currentDir.dropLast(1).dropLastWhile { it != '/' }
                    else -> "${currentDir}$dir/"
                }
            } else if (line.startsWith("dir ")) {
                dirs += "$currentDir${line.split(" ")[1]}/"
            } else if (line.first().isDigit()) {
                val (name, size) = line.split(" ").let { (s, n) -> n to s.toInt() }
                files[currentDir + name] = size
            }
        }
    }

}
