package problems.leetcode.easy

class LeetCode_557 {

    fun reverseWords(s: String): String {
        val result = StringBuilder(s)
        var resultCursor = 0

        var strCursor = 0
        while (strCursor < s.length) {
            val startIndex = strCursor
            while (strCursor < s.length && s[strCursor] != ' ') {
                strCursor++
            }
            val endIndex = strCursor - 1
            val nextWordStart = strCursor + 1

            val substring = s.substring(startIndex, endIndex + 1)
            var substringCursor = substring.lastIndex
            while (substringCursor >= 0) {
                result[resultCursor++] = substring[substringCursor--]
            }
            resultCursor++

            strCursor = nextWordStart
        }

        return result.toString()
    }
}