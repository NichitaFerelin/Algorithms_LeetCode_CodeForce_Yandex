package problems.codeForce

import readFromConsole

class `1213B` {
    fun alg() {
        val data = readFromConsole()

        for (index in 2 until data.size step 2) {
            val prices = data[index].split(" ").map { it.toInt() }
            var badDays = 0
            var min = prices[prices.lastIndex]

            for (priceIndex in prices.lastIndex - 1 downTo 0) {
                if (prices[priceIndex] > min) {
                    badDays++
                } else min = prices[priceIndex]
            }
            println(badDays)
        }
    }
}