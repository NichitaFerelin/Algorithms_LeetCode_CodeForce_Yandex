package problems.leetcode.medium

class LeetCode_198 {

    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return maxOf(nums[0], nums[1])

        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])

        for (index in 2 until dp.size) {
            dp[index] = maxOf(dp[index - 1], dp[index - 2] + nums[index])
        }
        return dp[dp.lastIndex]
    }
}