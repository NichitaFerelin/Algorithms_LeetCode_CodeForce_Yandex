package problems.easy

class LeetCode_819 {

    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val bannedWordContainer = HashMap<String, Unit>()
        banned.forEach { bannedWordContainer[it.toLowerCase()] = Unit }

        var mostPopularWord = ""
        var popularCounter = 0

        val wordsContainer = HashMap<String, Int>()

        var paragraphCursor = 0
        while (paragraphCursor < paragraph.length) {
            if (paragraph[paragraphCursor].isLetter()) {
                val wordStart = paragraphCursor

                paragraphCursor++
                while (paragraphCursor < paragraph.length && paragraph[paragraphCursor].isLetter()) {
                    paragraphCursor++
                }

                val resultWord = paragraph.substring(wordStart, paragraphCursor).toLowerCase()
                if (bannedWordContainer[resultWord] != null) continue

                val wordPopularity = wordsContainer.getOrDefault(resultWord, 0) + 1
                wordsContainer[resultWord] = wordPopularity

                if (wordPopularity > popularCounter) {
                    popularCounter = wordPopularity
                    mostPopularWord = resultWord
                }

            } else paragraphCursor++
        }
        return mostPopularWord
    }
}