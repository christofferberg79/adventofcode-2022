package cberg.aoc2022

class Day7(private val input: List<String>) {
    fun part1(): Int {
        var currentDir = "/"
        val dirs = mutableSetOf(currentDir)
        val files = mutableMapOf<String, Int>()
        for (line in input) {
            if (line.startsWith("$ cd ")) {
                val d = line.drop("$ cd ".length)
                currentDir = when (d) {
                    "/" -> d
                    ".." -> currentDir.dropLast(1).dropLastWhile { it != '/' }
                    else -> "$currentDir$d/"
                }
            } else if (line.startsWith("dir ")) {
                dirs += "$currentDir${line.drop("dir ".length)}/"
            } else if (line.first().isDigit()) {
                val (name, size) = line.split(" ").let { (s, n) -> n to s.toInt() }
                files[currentDir + name] = size
            }
        }
        return dirs.map { dir -> files.filterKeys { name -> name.startsWith(dir) }.values.sum() }
            .filter { size -> size <= 100000 }.sum()
    }

    fun part2() = 0
}
