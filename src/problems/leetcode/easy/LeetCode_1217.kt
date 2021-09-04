package problems.leetcode.easy

class LeetCode_1217 {
    fun minCostToMoveChips(position: IntArray): Int {
        var even = 0
        position.forEach { if (it % 2 == 0) even++ }
        return even.coerceAtMost(position.size - even)
    }
}