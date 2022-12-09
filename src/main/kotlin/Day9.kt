package cberg.aoc2022

class Day9(private val input: List<String>) {
    fun part1() = buildSet {
        var hx = 0
        var hy = 0
        var tx = 0
        var ty = 0
        input.map { it.split(" ") }
            .map { (a, b) -> a.single() to b.toInt() }
            .forEach { (dir, dist) ->
                repeat(dist) {
                    when (dir) {
                        'R' -> hx++
                        'L' -> hx--
                        'U' -> hy++
                        'D' -> hy--
                    }
                    val dx = hx - tx
                    val dy = hy - ty
                    when {
                        dx > 1 -> {
                            tx++
                            when {
                                dy > 0 -> ty++
                                dy < 0 -> ty--
                            }
                        }
                        dx < -1 -> {
                            tx--
                            when {
                                dy > 0 -> ty++
                                dy < 0 -> ty--
                            }
                        }
                        dy > 1 -> {
                            ty++
                            when {
                                dx > 0 -> tx++
                                dx < 0 -> tx--
                            }
                        }
                        dy < -1 -> {
                            ty--
                            when {
                                dx > 0 -> tx++
                                dx < 0 -> tx--
                            }
                        }
                    }
                    add(tx to ty)
                }
            }
    }.size

    fun part2() = 0
}
