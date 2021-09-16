package problems.leetcode.easy

import java.util.*

class LeetCode_2000 {

    fun reversePrefix(word: String, ch: Char): String {
        val result = StringBuilder(word)

        val endIndex = word.indexOf(ch)
        if (endIndex != -1) {
            val reversed = Stack<Char>()
            var strCursor = 0
            while (strCursor <= endIndex) {
                reversed.push(result[strCursor++])
            }
            strCursor = 0
            while (reversed.isNotEmpty()) {
                result[strCursor++] = reversed.pop()
            }
        }

        return result.toString()
    }
}