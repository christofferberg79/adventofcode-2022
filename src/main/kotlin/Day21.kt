package cberg.aoc2022

class Day21(input: List<String>) {
    fun part1() = monkeys.getValue("root").eval()

    fun part2() = 0

    private sealed interface Job {
        fun eval(): Long
    }

    private val monkeys: Map<String, Job> = parse(input)

    private class Const(val value: Long) : Job {
        override fun eval() = value
    }

    private open inner class Bin(val n1: String, val n2: String, val op: Long.(Long) -> Long) : Job {
        override fun eval() = monkeys.getValue(n1).eval().op(monkeys.getValue(n2).eval())
    }

    private inner class Add(n1: String, n2: String) : Bin(n1, n2, Long::plus)
    private inner class Sub(n1: String, n2: String) : Bin(n1, n2, Long::minus)
    private inner class Mult(n1: String, n2: String) : Bin(n1, n2, Long::times)
    private inner class Div(n1: String, n2: String) : Bin(n1, n2, Long::div)

    private fun parse(input: List<String>): Map<String, Job> {
        return input.associate { line ->
            val (name, job) = line.split(": ")
            name to parseJob(job)
        }
    }

    private fun parseJob(job: String) =
        if (job.all(Char::isDigit)) {
            Const(job.toLong())
        } else {
            val (n1, op, n2) = job.split(" ")
            when (op) {
                "+" -> Add(n1, n2)
                "-" -> Sub(n1, n2)
                "*" -> Mult(n1, n2)
                "/" -> Div(n1, n2)
                else -> error("invalid operation: $op")
            }
        }
}
