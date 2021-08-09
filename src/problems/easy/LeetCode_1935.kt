package problems.easy

class LeetCode_1935 {

    fun canBeTypedWords(text: String, brokenLetters: String): Int {
        val brokenContainer = HashMap<Char, Unit>()
        brokenLetters.forEach { symbol -> brokenContainer[symbol] = Unit }
        val words = text.split(" ")
        var canBeWritten = words.size

        words.forEach { word ->
            var wordCursor = 0
            while (wordCursor < word.length) {
                if (brokenContainer[word[wordCursor]] != null) {
                    canBeWritten--
                    break
                }
                wordCursor++
            }
        }

        return canBeWritten
    }
}