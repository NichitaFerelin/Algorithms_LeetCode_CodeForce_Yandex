package problems.leetcode.medium

class LeetCode_300 {

    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        dp[0] = 1

        var maxSubsequence = 1
        for (index in 1 until nums.size) {
            val currentNum = nums[index]

            var maxThatLess: Int? = null
            for (backCursor in index - 1 downTo 0) {
                if ((maxThatLess == null || dp[backCursor] > maxThatLess) && currentNum > nums[backCursor]) {
                    maxThatLess = dp[backCursor]
                }
            }
            dp[index] = maxThatLess?.plus(1) ?: 1

            if (dp[index] > maxSubsequence) {
                maxSubsequence = dp[index]
            }
        }

        return maxSubsequence
    }
}