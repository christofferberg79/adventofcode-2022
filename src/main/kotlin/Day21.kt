package cberg.aoc2022

class Day21(private val input: List<String>) {

    fun part1() = parse(input).toLong()

    fun part2(): Long {
        val root = parse(input, "humn").simplify() as Bin
        return when {
            root.right is Const -> solve(root.left, root.right)
            root.left is Const -> solve(root.right, root.left)
            else -> error("no solution")
        }
    }

    private sealed interface Expr {
        fun toLong() = (simplify() as Const).value
        fun simplify() = this
    }

    private class Const(val value: Long) : Expr

    private sealed class Bin(val left: Expr, val right: Expr, private val op: Long.(Long) -> Long) : Expr {
        abstract fun new(left: Expr, right: Expr): Expr
        abstract fun solveForLeft(result: Expr): Expr
        abstract fun solveForRight(result: Expr): Expr

        override fun simplify(): Expr {
            val simpleLeft = left.simplify()
            val simpleRight = right.simplify()
            return if (simpleLeft is Const && simpleRight is Const) {
                Const(simpleLeft.value.op(simpleRight.value))
            } else {
                new(simpleLeft, simpleRight)
            }
        }
    }

    private inner class Plus(left: Expr, right: Expr) : Bin(left, right, Long::plus) {
        override fun new(left: Expr, right: Expr) = left + right
        override fun solveForLeft(result: Expr) = result - right
        override fun solveForRight(result: Expr) = result - left
    }

    private inner class Minus(left: Expr, right: Expr) : Bin(left, right, Long::minus) {
        override fun new(left: Expr, right: Expr) = left - right
        override fun solveForLeft(result: Expr) = result + right
        override fun solveForRight(result: Expr) = left - result
    }

    private inner class Times(left: Expr, right: Expr) : Bin(left, right, Long::times) {
        override fun new(left: Expr, right: Expr) = left * right
        override fun solveForLeft(result: Expr) = result / right
        override fun solveForRight(result: Expr) = result / left
    }

    private inner class Div(left: Expr, right: Expr) : Bin(left, right, Long::div) {
        override fun new(left: Expr, right: Expr) = left / right
        override fun solveForLeft(result: Expr) = result * right
        override fun solveForRight(result: Expr) = left / result
    }

    private operator fun Expr.plus(other: Expr) = Plus(this, other)
    private operator fun Expr.minus(other: Expr) = Minus(this, other)
    private operator fun Expr.times(other: Expr) = Times(this, other)
    private operator fun Expr.div(other: Expr) = Div(this, other)

    private object Unknown : Expr

    private fun solve(lhs: Expr, rhs: Const): Long = when (lhs) {
        is Unknown -> rhs.value
        is Const -> error("There is no unknown in this equation")
        is Bin -> {
            val (newLhs, newRhs) = when {
                lhs.right is Const -> lhs.left to lhs.solveForLeft(rhs)
                lhs.left is Const -> lhs.right to lhs.solveForRight(rhs)
                else -> error("There are more than one unknown in this equation")
            }
            solve(newLhs, newRhs.simplify() as Const)
        }
    }

    private fun parse(input: List<String>, unknown: String? = null): Expr {
        val lookup = input.associate { line -> line.split(": ").let { (name, job) -> name to job } }
        return getJob("root", lookup, unknown)
    }

    private fun getJob(name: String, lookup: Map<String, String>, unknown: String?): Expr {
        if (name == unknown) {
            return Unknown
        }
        val job = lookup.getValue(name)
        if (job.all(Char::isDigit)) {
            return Const(job.toLong())
        }

        val (leftName, op, rightName) = job.split(" ")
        val left = getJob(leftName, lookup, unknown)
        val right = getJob(rightName, lookup, unknown)
        return when (op) {
            "+" -> left + right
            "-" -> left - right
            "*" -> left * right
            "/" -> left / right
            else -> error("invalid operation: $op")
        }
    }
}
