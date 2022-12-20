package cberg.aoc2022

class Day20(private val input: List<Int>) {
    fun part1() = solve()

    fun part2() = solve(811589153L, 10)

    private fun solve(factor: Long = 1, times: Int = 1): Long {
        val nodes = input.map { Node(it * factor) }

        nodes.windowed(2).forEach { (n1, n2) -> n2.insertAfter(n1) }

        repeat(times) {
            for (node in nodes) {
                node.moveRight(node.value.mod(input.size - 1))
            }
        }

        val zero = nodes.single { it.value == 0L }

        return zero[1000 % input.size].value + zero[2000 % input.size].value + zero[3000 % input.size].value
    }

    private class Node(val value: Long) {
        var prev = this
            private set
        var next = this
            private set

        operator fun get(i: Int): Node {
            check(i >= 0)
            var node = this
            repeat(i) { node = node.next }
            return node
        }

        fun insertAfter(node: Node) {
            this.next = node.next
            this.prev = node
            node.next.prev = this
            node.next = this
        }

        fun moveRight(n: Int) {
            require(n >= 0)
            if (n == 0) return
            var node = next
            remove()
            repeat(n - 1) {
                node = node.next
            }
            insertAfter(node)
        }

        private fun remove() {
            prev.next = next
            next.prev = prev
            prev = this
            next = this
        }
    }
}
