package problems.easy

class LeetCode_1768 {

    fun mergeAlternately(word1: String, word2: String): String {
        var word1Cursor = 0
        var word2Cursor = 0
        val resultStr = StringBuilder(word1 + word2)
        var resultStrCursor = 0
        while (word1Cursor < word1.length && word2Cursor < word2.length) {
            resultStr[resultStrCursor] = if (resultStrCursor % 2 == 0 || resultStrCursor == 0) {
                word1[word1Cursor++]
            } else word2[word2Cursor++]
            resultStrCursor++
        }

        while (word1Cursor < word1.length) {
            resultStr[resultStrCursor++] = word1[word1Cursor++]
        }

        while (word2Cursor < word2.length) {
            resultStr[resultStrCursor++] = word2[word2Cursor++]
        }

        return resultStr.toString()
    }
}