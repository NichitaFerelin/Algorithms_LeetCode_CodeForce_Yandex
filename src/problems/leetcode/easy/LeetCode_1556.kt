package problems.leetcode.easy

import java.util.*

class LeetCode_1556 {

    fun thousandSeparator(n: Int): String {
        val strNumber = n.toString()
        var strNumberCursor = strNumber.lastIndex
        val stackResult = Stack<Char>()

        var numCounter = 0
        while (strNumberCursor >= 0) {
            numCounter++

            if (numCounter == 3 && strNumberCursor > 0) {
                stackResult.push('.')
                numCounter = 0
            }
            stackResult.push(strNumber[strNumberCursor])
            strNumberCursor--
        }

        var result = ""
        while (stackResult.isNotEmpty()) result += stackResult.pop()
        return result
    }
}