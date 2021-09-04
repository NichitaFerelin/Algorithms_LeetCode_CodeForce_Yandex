package problems.leetcode.easy

class LeetCode_70 {

    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        val dp = IntArray(n)
        dp[0] = 1
        dp[1] = 2

        for (index in 2 until n) {
            dp[index] = dp[index - 1] + dp[index - 2]
        }
        return dp[dp.lastIndex]
    }
}