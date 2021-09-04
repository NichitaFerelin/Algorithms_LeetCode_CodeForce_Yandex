package problems.leetcode.easy

class LeetCode_746 {

    fun minCostClimbingStairs(cost: IntArray): Int {
        val dp = IntArray(cost.size)
        dp[0] = cost[0]
        dp[1] = cost[1]

        for (index in 2 until dp.size) {
            dp[index] = minOf(dp[index - 1], dp[index - 2]) + cost[index]
        }
        return minOf(dp[dp.lastIndex], dp[dp.lastIndex - 1])
    }
}