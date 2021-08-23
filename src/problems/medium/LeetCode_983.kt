package problems.medium

class LeetCode_983 {

    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val lastDay = days[days.lastIndex]

        val isTravelDays = BooleanArray(lastDay + 1)
        days.forEach { isTravelDays[it] = true }

        val dp = IntArray(lastDay + 1)

        for (index in 1..lastDay) {
            if (!isTravelDays[index]) {
                dp[index] = dp[index - 1]
                continue
            }

            dp[index] = costs[0] + dp[index - 1]
            dp[index] = (costs[1] + dp[(index - 7).coerceAtLeast(0)]).coerceAtMost(dp[index])
            dp[index] = (costs[2] + dp[(index - 30).coerceAtLeast(0)]).coerceAtMost(dp[index])
        }
        return dp[lastDay]
    }
}