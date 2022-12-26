package cberg.aoc2022

class Day25(private val input: List<String>) {
    fun part1() = decimalToSnafu(input.sumOf(::snafuToDecimal))

    fun part2() = 0

    companion object {
        fun snafuToDecimal(snafu: String) = snafu.foldRight(1L to 0L) { c, (f, d) ->
            f * 5 to d + f * c.snafuToInt()
        }.second

        private fun Char.snafuToInt() = when (this) {
            '-' -> -1
            '=' -> -2
            else -> digitToInt()
        }

        fun decimalToSnafu(decimal: Long): String {
            val maxes = buildMap {
                var factor = 1L
                var max = 0L
                do {
                    max += factor * 2
                    put(factor, max)
                    factor *= 5
                } while (decimal !in -max..max)
            }
            var rest = decimal
            var snafu = ""
            maxes.keys.sortedDescending().windowed(2).forEach { (factor, nextFactor) ->
                val d = (-2L..2L).first { (rest - it * factor) in (-maxes[nextFactor]!!..maxes[nextFactor]!!) }
                snafu += d.toSnafuChar()
                rest -= d * factor
            }
            snafu += rest.toSnafuChar()

            return snafu
        }

        private fun Long.toSnafuChar(): String {
            require(this in -2L..2L)
            return when (this) {
                -2L -> "="
                -1L -> "-"
                else -> toString()
            }
        }
    }
}

