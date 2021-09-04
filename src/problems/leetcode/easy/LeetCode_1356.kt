package problems.leetcode.easy

import java.util.*


class LeetCode_1356 {

    fun sortByBits(arr: IntArray): IntArray {
        val n: Int = arr.size
        val res = IntArray(n)
        for (i in 0 until n) {
            res[i] = countBitOne(arr[i]) * 10001 + arr[i]
        }

        Arrays.sort(res)
        for (i in 0 until n) {
            res[i] %= 10001
        }

        return res
    }

    private fun countBitOne(n: Int): Int {
        var num = n
        var res = 0
        while (num != 0) {
            res += num and 1
            num = num shr 1
        }
        return res
    }
}