package problems.leetcode.medium

class LeetCode_1877 {

    fun minPairSum(nums: IntArray): Int {
        nums.sort()

        var max = Int.MIN_VALUE
        for (index in 0 until nums.size / 2) {
            val currentSum = nums[index] + nums[nums.size - index - 1]
            if (currentSum > max) {
                max = currentSum
            }
        }

        return max
    }
}