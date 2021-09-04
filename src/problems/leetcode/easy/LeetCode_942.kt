package problems.leetcode.easy

class LeetCode_942 {

    fun replaceElements(arr: IntArray): IntArray {
        val resultArr = IntArray(arr.size)
        resultArr[resultArr.lastIndex] = -1

        var arrCursor = resultArr.lastIndex - 1
        var max = arr[resultArr.lastIndex]
        while (arrCursor >= 0) {
            resultArr[arrCursor] = max
            if (arr[arrCursor] > max) {
                max = arr[arrCursor]
            }
            arrCursor--
        }

        return resultArr
    }
}