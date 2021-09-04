package problems.leetcode.easy

import java.util.*

class LeetCode_917 {

    fun reverseOnlyLetters(s: String): String {
        val sStack = Stack<Char>()
        val result = CharArray(s.length)
        s.forEachIndexed { index, symbol ->
            if (symbol.isLetter()) {
                sStack.push(symbol)
            } else result[index] = symbol
        }

        var arrCursor = 0
        while (sStack.isNotEmpty()) {
            if (result[arrCursor] == '\u0000') {
                result[arrCursor] = sStack.pop()
            }
            arrCursor++
        }

        var res = ""
        result.forEach { res += it }

        return res
    }
}