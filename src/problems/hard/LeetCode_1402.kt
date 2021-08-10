package problems.hard

class LeetCode_1402 {

    fun maxSatisfaction(satisfaction: IntArray): Int {
        val sortedArr = satisfaction.sortedArray()

        var result = 0
        var total = 0
        var arrCursor = sortedArr.lastIndex

        while (arrCursor >= 0 && sortedArr[arrCursor] > -total) {
            total += sortedArr[arrCursor]
            result += total
            arrCursor--
        }

        return result
    }
}