package problems.leetcode.medium

class LeetCode_720 {

    fun longestWord(words: Array<String>): String {
        val sortedWords = words.sortedByDescending { it.length }
        val wordsBuildContainer = HashMap<String, Unit>()
        sortedWords.forEach { wordsBuildContainer[it] = Unit }

        val allResults = mutableListOf<String>()

        var longestWordCounter = 0
        sortedWords.forEach { currentWord ->
            var stepCounter = 1
            var stepWord = currentWord
            while (stepWord.length != 1) {
                if (wordsBuildContainer[stepWord] == null) {
                    break
                } else {
                    stepCounter++
                    stepWord = stepWord.substring(0, stepWord.lastIndex)
                }
            }

            if (wordsBuildContainer[stepWord] != null) {
                if (longestWordCounter < stepCounter) {
                    allResults.clear()
                    longestWordCounter = stepCounter
                    allResults.add(currentWord)
                } else if (longestWordCounter == stepCounter) {
                    allResults.add(currentWord)
                }
            }
        }

        allResults.sort()
        return allResults.getOrNull(0) ?: ""
    }
}