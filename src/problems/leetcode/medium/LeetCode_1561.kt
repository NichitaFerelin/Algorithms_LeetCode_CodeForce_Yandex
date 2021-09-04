package problems.leetcode.medium

class LeetCode_1561 {

    fun maxCoins(piles: IntArray): Int {
        var arrCursor = piles.size / 3
        piles.sort()
        var total = 0
        while (arrCursor < piles.size - 2) {
            total += piles[arrCursor]
            arrCursor += 2
        }
        total += piles[arrCursor]
        return total
    }
}