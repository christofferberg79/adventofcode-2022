package cberg.aoc2022

import kotlin.math.min

class Day13(private val input: List<String>) {
    fun part1() = (0..input.lastIndex step 3)
        .map { i -> input[i] to input[i + 1] }
        .mapIndexed { index, pair -> index to pair }
        .filter { (_, pair) -> pair.isInTheRightOrder() }
        .sumOf { (index, _) -> index + 1 }

    fun part2() = 0

    private sealed interface E
    private class I(val value: Int) : E
    private class L(val list: List<E>) : E

    private fun L(e: E) = L(listOf(e))

    private operator fun E.compareTo(other: E): Int {
        return when (this) {
            is I -> when (other) {
                is I -> this.value.compareTo(other.value)
                is L -> L(this).compareTo(other)
            }

            is L -> when (other) {
                is I -> this.compareTo(L(other))
                is L -> {
                    for (i in 0..min(this.list.lastIndex, other.list.lastIndex)) {
                        val comp = this.list[i].compareTo(other.list[i])
                        if (comp != 0) {
                            return comp
                        }
                    }
                    this.list.size.compareTo(other.list.size)
                }
            }
        }
    }

    private class Parser(private val s: String) {
        private var pos = 0

        fun parseList(): L {
            pos++
            val list = mutableListOf<E>()
            while (s[pos] != ']') {
                when (s[pos]) {
                    '[' -> list.add(parseList())
                    ',' -> pos++
                    else -> list.add(parseInt())
                }
            }
            pos++
            return L(list)
        }

        private fun parseInt(): I {
            val digits = s.drop(pos).takeWhile(Char::isDigit)
            pos += digits.length
            return I(digits.toInt())
        }
    }

    private fun parse(s: String): E {
        return Parser(s).parseList()
    }

    private fun Pair<String, String>.isInTheRightOrder() = parse(first) <= parse(second)
}
