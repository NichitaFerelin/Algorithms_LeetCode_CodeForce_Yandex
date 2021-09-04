package problems.leetcode.easy

class LeetCode_1455 {

    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        val words = sentence.split(" ")

        var maxSubstingWord = -1
        var concurrenceWord = -1
        words.forEachIndexed { index, word ->
            if (searchWord.length > word.length) return@forEachIndexed

            var wordCursor = 0
            var searchWordCursor = 0
            var totalConcurrences = 0
            while (
                wordCursor < word.length
                && searchWordCursor < searchWord.length
                && word[wordCursor] == searchWord[searchWordCursor]
            ) {
                totalConcurrences++
                wordCursor++
                searchWordCursor++
            }

            if (totalConcurrences > 1 && totalConcurrences > maxSubstingWord) {
                maxSubstingWord = totalConcurrences
                concurrenceWord = index + 1
            }
        }

        return concurrenceWord
    }
}