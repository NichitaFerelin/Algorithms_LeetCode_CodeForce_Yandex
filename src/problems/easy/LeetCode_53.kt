package problems.easy

class LeetCode_53 {

    fun maxSubArray(nums: IntArray): Int {
        val dp = IntArray(nums.size)

        dp[0] = nums[0]
        var max = dp[0]

        for (index in 1 until dp.size) {
            dp[index] = nums[index] + if (dp[index - 1] > 0) dp[index - 1] else 0
            max = max.coerceAtLeast(dp[index])
        }

        return max
    }
}