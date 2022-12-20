package cberg.aoc2022

class Day20(private val input: List<Int>) {
    fun part1(): Int {
        val nodes = input.map(::Node)

        nodes.windowed(2).forEach { (n1, n2) -> n2.insertAfter(n1) }

        for (node in nodes) {
            when {
                node.value > 0 -> node.moveRight(node.value)
                node.value < 0 -> node.moveLeft(-node.value)
            }
        }

        val zero = nodes.single { it.value == 0 }

        return zero[1000 % input.size].value + zero[2000 % input.size].value + zero[3000 % input.size].value
    }

    fun part2() = 0

    private class Node(val value: Int) {
        private var prev = this
        private var next = this

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

        fun insertBefore(node: Node) {
            this.next = node
            this.prev = node.prev
            node.prev.next = this
            node.prev = this
        }

        fun moveRight(n: Int) {
            check(n > 0)
            var node = next
            remove()
            repeat(n - 1) {
                node = node.next
            }
            insertAfter(node)
        }

        fun moveLeft(n: Int) {
            check(n > 0)
            var node = prev
            remove()
            repeat(n - 1) {
                node = node.prev
            }
            insertBefore(node)
        }

        private fun remove() {
            prev.next = next
            next.prev = prev
            prev = this
            next = this
        }
    }
}
