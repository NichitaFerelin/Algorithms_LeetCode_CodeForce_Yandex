package problems.leetcode.medium

class LeetCode_309 {

    fun maxProfit(prices: IntArray): Int {
        if(prices.size == 1) return 0

        val s0 = IntArray(prices.size)
        val s1 = IntArray(prices.size)
        val s2 = IntArray(prices.size)

        s1[0] = -prices[0]
        s2[0] = Int.MIN_VALUE

        for (index in 1 until prices.size) {
            s0[index] = maxOf(s0[index - 1], s2[index - 1])
            s1[index] = maxOf(s1[index - 1], s0[index - 1] - prices[index])
            s2[index] = s1[index - 1] + prices[index]
        }

        return maxOf(s0[s0.lastIndex], s2[s2.lastIndex])
    }
}