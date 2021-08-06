package problems.medium

class LeetCode_890 {

    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        val patternArrKeys = IntArray(pattern.length)
        var patternFreeKey = 0
        val patternMap = HashMap<Char, Int>(pattern.length)

        pattern.forEachIndexed { index, symbol ->
            val symbolIndexAtContainer = patternMap[symbol]
            if (symbolIndexAtContainer == null) {
                patternMap[symbol] = index
                patternArrKeys[index] = patternFreeKey
                patternFreeKey++
            } else patternArrKeys[index] = patternArrKeys[symbolIndexAtContainer]
        }

        val results = mutableListOf<String>()
        for (word in words) {
            if (word.length != pattern.length) {
                continue
            }

            if (word.length == 1) {
                results.add(word)
                continue
            }

            var isFits = true
            val wordContainer = HashMap<Char, Int>(word.length)
            var wordFreeKey = 0
            for ((index, symbol) in word.withIndex()) {
                var symbolKeyAtContainer = wordContainer[symbol]
                if (symbolKeyAtContainer == null) {
                    wordContainer[symbol] = wordFreeKey
                    symbolKeyAtContainer = wordFreeKey
                    wordFreeKey++
                }

                if (symbolKeyAtContainer != patternArrKeys[index]) {
                    isFits = false
                    break
                }
            }

            if (isFits) {
                results.add(word)
            }
        }

        return results
    }
}