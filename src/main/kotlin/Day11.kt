package cberg.aoc2022

class Day11(private val monkeys: List<Monkey>) {
    fun part1(): Int {
        repeat(20) {
            for (monkey in monkeys) {
                while (monkey.items.isNotEmpty()) {
                    val (worry, target) = monkey.inspect(monkey.items.removeFirst())
                    monkeys[target].items += worry
                }
            }
        }
        return monkeys.sortedBy { it.activity }.takeLast(2).let { (m1, m2) -> m1.activity * m2.activity }
    }

    fun part2() = 0

    class Monkey(
        val items: MutableList<Int>,
        val op: (Int) -> Int,
        val div: Int,
        val ifTrue: Int,
        val ifFalse: Int
    ) {
        var activity = 0

        fun inspect(item: Int): Pair<Int, Int> {
            activity++
            val worry = op(item) / 3
            val target = if (worry % div == 0) ifTrue else ifFalse
            return worry to target
        }
    }
}
