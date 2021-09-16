package problems.leetcode.easy

class LeetCode_121 {

    fun maxProfit(prices: IntArray): Int {
        if (prices.size == 1) return 0

        var result = 0
        var buyPrice = prices[0]

        for (index in 1 until prices.size) {
            if (prices[index] > buyPrice) {
                if (result < prices[index] - buyPrice) {
                    result = prices[index] - buyPrice
                }
            } else {
                buyPrice = prices[index]
            }
        }
        return result
    }
}