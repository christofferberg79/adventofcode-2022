package cberg.aoc2022

class Day21(private val input: List<String>) {

    fun part1() = parse(input).toLong()

    fun part2(): Long {
        val root = parse(input, "humn").simplify() as Bin
        return when {
            root.rhs is Const -> solve(root.lhs, root.rhs)
            root.lhs is Const -> solve(root.rhs, root.lhs)
            else -> error("no solution")
        }
    }

    private sealed interface Expr {
        fun toLong() = (simplify() as Const).value
        fun simplify() = this
    }

    private class Const(val value: Long) : Expr

    private sealed class Bin(val lhs: Expr, val rhs: Expr, private val op: Long.(Long) -> Long) : Expr {
        abstract fun new(lhs: Expr, rhs: Expr): Expr
        abstract fun solveLhs(e: Expr): Expr
        abstract fun solveRhs(e: Expr): Expr

        override fun simplify(): Expr {
            val simpleLhs = lhs.simplify()
            val simpleRhs = rhs.simplify()
            return if (simpleLhs is Const && simpleRhs is Const) {
                Const(simpleLhs.value.op(simpleRhs.value))
            } else {
                new(simpleLhs, simpleRhs)
            }
        }
    }

    private inner class Add(lhs: Expr, n2: Expr) : Bin(lhs, n2, Long::plus) {
        override fun new(lhs: Expr, rhs: Expr) = Add(lhs, rhs)
        override fun solveLhs(e: Expr) = Sub(e, rhs) // x + a = b --> x = b - a
        override fun solveRhs(e: Expr) = Sub(e, lhs) // a + x = b --> x = b - a
    }

    private inner class Sub(lhs: Expr, rhs: Expr) : Bin(lhs, rhs, Long::minus) {
        override fun new(lhs: Expr, rhs: Expr) = Sub(lhs, rhs)
        override fun solveLhs(e: Expr) = Add(e, rhs) // x - a = b --> x = b + a
        override fun solveRhs(e: Expr) = Sub(lhs, e) // a - x = b --> x = a - b
    }

    private inner class Mult(lhs: Expr, rhs: Expr) : Bin(lhs, rhs, Long::times) {
        override fun new(lhs: Expr, rhs: Expr) = Mult(lhs, rhs)
        override fun solveLhs(e: Expr) = Div(e, rhs) // x * a = b --> x = b / a
        override fun solveRhs(e: Expr) = Div(e, lhs) // a * x = b --> x = b / a
    }

    private inner class Div(lhs: Expr, rhs: Expr) : Bin(lhs, rhs, Long::div) {
        override fun new(lhs: Expr, rhs: Expr) = Div(lhs, rhs)
        override fun solveLhs(e: Expr) = Mult(e, rhs) // x / a = b --> x = b * a
        override fun solveRhs(e: Expr) = Div(lhs, e) // a / x = b --> x = a / b
    }

    private inner class Unknown : Expr

    private fun solve(lhs: Expr, rhs: Const): Long = when (lhs) {
        is Unknown -> rhs.value
        is Const -> error("There is no unknown in this equation")
        is Bin -> {
            val (newLhs, newRhs) = when {
                lhs.rhs is Const -> lhs.lhs to lhs.solveLhs(rhs)
                lhs.lhs is Const -> lhs.rhs to lhs.solveRhs(rhs)
                else -> error("There are more than one unknowns in this equation")
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
            return Unknown()
        }
        val job = lookup.getValue(name)
        if (job.all(Char::isDigit)) {
            return Const(job.toLong())
        }

        val (lhsName, op, rhsName) = job.split(" ")
        val lhs = getJob(lhsName, lookup, unknown)
        val rhs = getJob(rhsName, lookup, unknown)
        return when (op) {
            "+" -> Add(lhs, rhs)
            "-" -> Sub(lhs, rhs)
            "*" -> Mult(lhs, rhs)
            "/" -> Div(lhs, rhs)
            else -> error("invalid operation: $op")
        }
    }
}
