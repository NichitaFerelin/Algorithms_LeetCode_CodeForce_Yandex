package problems.leetcode.easy

class LeetCode_884 {

    fun uncommonFromSentences(s1: String, s2: String): Array<String> {
        val firstStrWords = readWordsInMap(s1)
        val secondStrWords = readWordsInMap(s2)

        val uncommonWords = mutableListOf<String>()

        for (map in firstStrWords) {
            val word = map.key
            val counter = map.value

            if (counter > 1) continue

            val wordAtSecondContainer = secondStrWords[word]
            if (wordAtSecondContainer == null) {
                uncommonWords.add(word)
            }
        }

        for (map in secondStrWords) {
            val word = map.key
            val counter = map.value

            if (counter > 1) continue

            val wordAtFirstContainer = firstStrWords[word]
            if (wordAtFirstContainer == null) {
                uncommonWords.add(word)
            }
        }

        return uncommonWords.toTypedArray()
    }

    private fun readWordsInMap(str: String): HashMap<String, Int> {
        val wordsContainer = HashMap<String, Int>()

        var cursor = 0
        var wordStart = cursor

        while (cursor < str.length) {
            if (str[cursor] == ' ') {
                val word = str.substring(wordStart, cursor)
                wordsContainer[word] = wordsContainer.getOrDefault(word, 0) + 1
                wordStart = ++cursor
            } else cursor++
        }

        val word = str.substring(wordStart, cursor)
        wordsContainer[word] = wordsContainer.getOrDefault(word, 0) + 1

        return wordsContainer
    }
}