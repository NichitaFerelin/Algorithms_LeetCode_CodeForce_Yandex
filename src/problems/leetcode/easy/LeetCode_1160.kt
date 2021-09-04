package problems.leetcode.easy

class LeetCode_1160 {

    fun countCharacters(words: Array<String>, chars: String): Int {
        val availableChars = HashMap<Char, Int>(chars.length)
        chars.forEach { availableChars[it] = availableChars.getOrDefault(it, 0) + 1 }

        val goodWords = mutableListOf<String>()
        words.forEach { word ->
            val wordContainer = HashMap<Char, Int>(word.length)
            word.forEach { symbol -> wordContainer[symbol] = wordContainer.getOrDefault(symbol, 0) + 1 }

            var isGood = true
            wordContainer.forEach { map ->
                if (availableChars[map.key] == null || availableChars[map.key]!! < map.value) {
                    isGood = false
                }
            }

            if (isGood) goodWords.add(word)
        }

        return goodWords.sumBy { it.length }
    }
}