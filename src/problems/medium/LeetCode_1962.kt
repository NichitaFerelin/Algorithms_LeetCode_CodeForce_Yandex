package problems.medium

import kotlin.collections.ArrayList

class LeetCode_1962 {

    fun minStoneSum(piles: IntArray, k: Int): Int {
        val sortedPiles = ArrayList(piles.sortedByDescending { it - it / 2 })
        var operations = k

        while (operations > 0) {
            sortedPiles[0] = sortedPiles[0] - sortedPiles[0] / 2
            operations--

            if (sortedPiles.size == 2 && sortedPiles[0] < sortedPiles[1]) {
                val temp = sortedPiles[0]
                sortedPiles[0] = sortedPiles[1]
                sortedPiles[1] = temp
            } else if (sortedPiles.size > 1 && sortedPiles.size != 2) {
                val tempTarget = sortedPiles[0]
                sortedPiles.removeAt(0)
                val newPosition = kotlin.math.abs(sortedPiles.binarySearch(tempTarget))
                sortedPiles.add(newPosition, tempTarget)
            }
        }

        return sortedPiles.sum()
    }
}