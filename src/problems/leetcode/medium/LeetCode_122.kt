package problems.leetcode.medium

class LeetCode_122 {

    fun maxProfit(prices: IntArray): Int {
        var lastBuy = -prices[0]
        var lastSold = 0

        for (index in 1 until prices.size) {
            val currentBuy = maxOf(lastBuy, lastSold - prices[index])
            val currentSold = maxOf(lastSold, lastBuy + prices[index])
            lastBuy = currentBuy
            lastSold = currentSold
        }
        return lastSold
    }
}