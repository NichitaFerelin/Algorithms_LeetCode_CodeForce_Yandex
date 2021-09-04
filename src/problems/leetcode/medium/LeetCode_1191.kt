package problems.leetcode.medium

class LeetCode_1191 {

    fun kConcatenationMaxSum(arr: IntArray, k: Int): Int {
        var containMinus = false
        var containPlus = false
        var sum = 0

        arr.forEach { number ->
            sum += number
            if (number < 0) {
                containMinus = true
            } else if (number > 0) {
                containPlus = true
            }
        }

        return when {
            !containPlus -> 0
            k == 0 -> sum
            !containMinus -> sum * k
            else -> {
                var throughAmount = 0
                var arrCursor = 0
                while (arrCursor < arr.size && arr[arrCursor] >= 0) {
                    throughAmount += arr[arrCursor++]
                }
                arrCursor = arr.lastIndex

                while (arr[arrCursor] >= 0) {
                    throughAmount += arr[arrCursor--]
                }
                throughAmount
            }
        }
    }
}