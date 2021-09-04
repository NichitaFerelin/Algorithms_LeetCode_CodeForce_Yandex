package problems.leetcode.easy

class LeetCode_1287 {

    fun findSpecialInteger(arr: IntArray): Int {
        val percents = arr.size * 25 / 100

        var numberSequenceCounter = 0
        var arrCursor = 1
        while (arrCursor < arr.size) {
            if (arr[arrCursor - 1] == arr[arrCursor]) {
                numberSequenceCounter++
            } else {
                if (numberSequenceCounter > percents) {
                    return arr[arrCursor - 1]
                }
                numberSequenceCounter = 1
            }
            arrCursor++
        }

        return arr[arr.lastIndex]
    }
}