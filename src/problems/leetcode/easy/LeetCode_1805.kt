package problems.leetcode.easy

class LeetCode_1805 {

    fun numDifferentIntegers(word: String): Int {
        val nums = mutableSetOf<String>()

        var wordCursor = 0
        while (wordCursor < word.length) {
            if (word[wordCursor].isDigit()) {
                while (wordCursor < word.length && word[wordCursor] == '0') {
                    wordCursor++
                }

                if (wordCursor < word.length) {
                    if (word[wordCursor].isDigit()) {
                        val wordStart = wordCursor
                        while (wordCursor < word.length && word[wordCursor].isDigit()) {
                            wordCursor++
                        }

                        val resultNumber = if (wordStart == wordCursor) {
                            word[wordCursor].toString()
                        } else word.substring(wordStart, wordCursor)
                        nums.add(resultNumber)
                        wordCursor++
                    } else nums.add("0")
                }else nums.add("0")
            } else wordCursor++
        }

        return nums.size
    }
}