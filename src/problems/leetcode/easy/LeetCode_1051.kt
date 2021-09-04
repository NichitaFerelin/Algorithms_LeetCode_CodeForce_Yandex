package problems.leetcode.easy

class LeetCode_1051 {

    fun heightChecker(heights: IntArray): Int {
        val expected = heights.sortedArray()
        var counter = 0
        heights.forEachIndexed { index, num -> if (num != expected[index]) counter++ }
        return counter
    }
}