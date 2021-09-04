package problems.leetcode.easy

class LeetCode_1304 {

    fun sumZero(n: Int): IntArray {
        var arrCursor = 0
        val result = IntArray(n)

        while (arrCursor < result.size - 1) {
            val uniqueNum = arrCursor + 2
            result[arrCursor] = uniqueNum
            result[arrCursor + 1] = uniqueNum - uniqueNum - uniqueNum
            arrCursor += 2
        }

        if (n % 2 != 0) {
            result[result.size - 1] = 0
        }

        return result
    }
}