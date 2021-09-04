package problems.leetcode.easy

/**
 * You are given a 0-indexed string s that has lowercase English letters in its even indices and digits in its odd indices.

There is a function shift(c, x), where c is a character and x is a digit, that returns the xth character after c.

For example, shift('a', 5) = 'f' and shift('x', 0) = 'x'.
For every odd index i, you want to replace the digit s[i] with shift(s[i-1], s[i]).

Return s after replacing all digits. It is guaranteed that shift(s[i-1], s[i]) will never exceed 'z'.
 * */

class LeetCode_1844 {

    fun replaceDigits(s: String): String {
        val result = StringBuilder(s)
        var strCursor = 0
        while (strCursor < s.length - 1) {
            result[strCursor + 1] = result[strCursor].plus(result[strCursor + 1].toString().toInt())
            strCursor += 2
        }

        return result.toString()
    }
}