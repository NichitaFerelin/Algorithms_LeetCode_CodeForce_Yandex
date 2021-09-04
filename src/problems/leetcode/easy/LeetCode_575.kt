package problems.leetcode.easy

class LeetCode_575 {

    fun distributeCandies(candyType: IntArray): Int {
        val types = candyType.toSet()
        return if (types.size > candyType.size / 2) candyType.size / 2 else types.size
    }
}