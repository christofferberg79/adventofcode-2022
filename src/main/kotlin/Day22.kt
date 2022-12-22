package cberg.aoc2022

class Day22(input: List<String>) {
    private val map = input.subList(0, input.indexOfFirst(String::isBlank))
    private val instructions = parseInstructions(input[input.indexOfFirst(String::isBlank) + 1])

    fun part1(): Int {
        var pos = Vec(map[0].indexOfFirst { it == '.' }, 0)
        var dir = Vec(1, 0)
        for (i in instructions) {
            when (i) {
                is Rotate -> dir = dir.rotate(i.dir)
                is Move -> repeat(i.dist) {
                    pos = move(pos, dir)
                }
            }
        }
        return password(pos, dir)
    }

    fun part2() = 0

    private fun parseInstructions(s: String): List<Instruction> {
        return buildList {
            var i = 0
            while (i < s.length) {
                val i0 = i
                while (i < s.length && s[i].isDigit()) {
                    i++
                }
                if (i > i0) {
                    add(Move(s.substring(i0, i).toInt()))
                } else {
                    add(Rotate(s[i]))
                    i++
                }
            }
        }
    }

    private data class Vec(val x: Int, val y: Int)

    private operator fun Vec.plus(other: Vec) = Vec(this.x + other.x, this.y + other.y)
    private val right = Vec(1, 0)
    private val down = Vec(0, 1)
    private val left = Vec(-1, 0)
    private val up = Vec(0, -1)

    private fun Vec.rotate(dir: Char): Vec {
        return when (dir) {
            'R' -> Vec(-y, x)
            'L' -> Vec(y, -x)
            else -> error("invalid rotation: $dir")
        }
    }

    private fun move(pos: Vec, dir: Vec): Vec {
        var nextPos = pos + dir
        if (nextPos.isOffTheMap()) {
            nextPos = when (dir) {
                right -> leftEdge(pos.y)
                down -> topEdge(pos.x)
                left -> rightEdge(pos.y)
                up -> bottomEdge(pos.x)
                else -> error("invalid directions: $dir")
            }
        }
        return if (nextPos.isOpenTile()) nextPos else pos
    }

    private fun Vec.isOffTheMap() = y !in map.indices || x !in map[y].indices || map[y][x] == ' '
    private fun leftEdge(y: Int) = Vec(map[y].indexOfFirst { it != ' ' }, y)
    private fun topEdge(x: Int) = Vec(x, map.indexOfFirst { x in it.indices && it[x] != ' ' })
    private fun rightEdge(y: Int) = Vec(map[y].indexOfLast { it != ' ' }, y)
    private fun bottomEdge(x: Int) = Vec(x, map.indexOfLast { x in it.indices && it[x] != ' ' })
    private fun Vec.isOpenTile() = map[y][x] == '.'

    private sealed interface Instruction
    private data class Move(val dist: Int) : Instruction
    private data class Rotate(val dir: Char) : Instruction

    private fun password(pos: Vec, dir: Vec): Int {
        val facing = when (dir) {
            right -> 0
            down -> 1
            left -> 2
            up -> 3
            else -> error("invalid directions: $dir")
        }
        return 1000 * (pos.y + 1) + 4 * (pos.x + 1) + facing
    }
}
