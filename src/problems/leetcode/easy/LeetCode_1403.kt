package problems.leetcode.easy

class LeetCode_1403 {

    fun minSubsequence(nums: IntArray): List<Int> {
        var totalSum = nums.sum()
        var numCursor = 0
        val numSorted = nums.sortedDescending()

        val result = mutableListOf<Int>()
        var resultSum = 0

        while (resultSum <= totalSum) {
            resultSum += numSorted[numCursor]
            totalSum -= numSorted[numCursor]
            result.add(numSorted[numCursor])
            numCursor++
        }

        return result
    }
}