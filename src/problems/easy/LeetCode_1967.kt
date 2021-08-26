package problems.easy

class LeetCode_1967 {

    fun numOfStrings(patterns: Array<String>, word: String): Int {
        var totalAppears = 0
        patterns.forEach { patternWord ->
            if (patternWord.length > word.length) return@forEach

            var wordCursor = 0
            var isFound = false

            while (!isFound && wordCursor < word.length) {
                var tempCursor = wordCursor
                var patternWordCursor = 0

                while (tempCursor < word.length && patternWord[0] != word[tempCursor]) {
                    tempCursor++
                }

                wordCursor = tempCursor + 1

                while (patternWordCursor < patternWord.length
                    && tempCursor < word.length
                    && patternWord[patternWordCursor] == word[tempCursor]
                ) {
                    tempCursor++
                    patternWordCursor++
                }

                if (patternWordCursor >= patternWord.length) {
                    isFound = true
                    totalAppears++
                }
            }
        }

        return totalAppears
    }
}