package problems.easy

class LeetCode_1475 {

    fun finalPrices(prices: IntArray): IntArray {
        return IntArray(prices.size) { index ->
            val currentPrice = prices[index]

            var pricesCursor = index + 1
            var newPrice = 0
            while (pricesCursor < prices.size && newPrice == 0) {
                if(prices[pricesCursor] < currentPrice) {
                    newPrice = currentPrice - prices[pricesCursor]
                }
                pricesCursor++
            }

            newPrice
        }
    }
}