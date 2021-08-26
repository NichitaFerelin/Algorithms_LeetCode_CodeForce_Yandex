package problems.easy

class LeetCode_122 {

    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) return 0

        var res = 0

        for (index in 1 until prices.size) {
            if (prices[index] - prices[index - 1] > 0) {
                res += prices[index] - prices[index - 1]
            }
        }

        return res
    }
}