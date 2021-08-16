package problems.easy

class LeetCode_1619 {

    fun trimMean(arr: IntArray): Double {
        val sortedArr = arr.sorted().toMutableList()
        val itemsToRemove = arr.size * 5 / 100

        var toRemove = itemsToRemove
        while (toRemove-- > 0) {
            sortedArr.removeAt(0)
            sortedArr.removeAt(sortedArr.lastIndex)
        }

        return sortedArr.sum().toDouble() / sortedArr.size
    }
}