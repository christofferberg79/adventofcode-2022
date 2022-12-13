package cberg.aoc2022

import kotlin.math.min

class Day13(private val input: List<String>) {
    fun part1() = (0..input.lastIndex step 3)
        .map { i -> parse(input[i]) to parse(input[i + 1]) }
        .mapIndexed { index, pair -> index + 1 to pair }
        .filter { (_, pair) -> pair.first <= pair.second }
        .sumOf { (index, _) -> index }

    fun part2(): Int {
        val div1 = "[[2]]"
        val div2 = "[[6]]"
        val sorted = (input + div1 + div2)
            .filter(String::isNotBlank)
            .map { s -> s to parse(s) }
            .sortedBy { (_, p) -> p }
        val i1 = sorted.indexOfFirst { (s, _) -> s == div1 } + 1
        val i2 = sorted.indexOfFirst { (s, _) -> s == div2 } + 1
        return i1 * i2
    }

    private sealed interface E : Comparable<E>
    private class I(val value: Int) : E {
        override fun compareTo(other: E) = when (other) {
            is I -> this.value.compareTo(other.value)
            is L -> L(listOf(this)).compareTo(other)
        }
    }

    private class L(val list: List<E>) : E {
        override fun compareTo(other: E) = when (other) {
            is I -> compareTo(L(listOf(other)))
            is L -> compareTo(other)
        }

        fun compareTo(other: L): Int {
            for (i in 0..min(this.list.lastIndex, other.list.lastIndex)) {
                val comp = this.list[i].compareTo(other.list[i])
                if (comp != 0) {
                    return comp
                }
            }
            return this.list.size.compareTo(other.list.size)
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
}
