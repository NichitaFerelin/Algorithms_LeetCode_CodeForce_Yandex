package problems.leetcode.easy

class LeetCode_1078 {

    fun findOcurrences(text: String, first: String, second: String): Array<String> {
        val result = mutableListOf<String>()

        var textCursor = 0
        while (textCursor < text.length && text[textCursor] != ' ') {
            textCursor++
        }

        var firstWord = text.substring(0, textCursor)

        val wordStart = ++textCursor
        while (textCursor < text.length && text[textCursor] != ' ') {
            textCursor++
        }
        var secondWord = text.substring(wordStart, textCursor)

        var currentWordStart = ++textCursor
        while (true) {
            if (textCursor == text.length || text[textCursor] == ' ') {
                val currentWord = text.substring(currentWordStart, textCursor)
                if (firstWord == first && secondWord == second) {
                    result.add(currentWord)
                }

                firstWord = secondWord
                secondWord = currentWord

                if (textCursor == text.length) {
                    break
                }

                currentWordStart = ++textCursor
            } else textCursor++
        }

        return Array(result.size) { result[it] }
    }
}