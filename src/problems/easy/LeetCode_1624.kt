package problems.easy

class LeetCode_1624 {

    fun maxLengthBetweenEqualCharacters(s: String): Int {
        val charsContainer = HashMap<Char, Int>()
        var largestSubstring = -1

        var strCursor = 0
        while (strCursor < s.length) {
            val currentSymbol = s[strCursor]
            val symbolPreviousPosition = charsContainer[currentSymbol]

            if (symbolPreviousPosition != null) {
                val substringSize = strCursor - symbolPreviousPosition - 1
                if (substringSize > largestSubstring) {
                    largestSubstring = substringSize
                }
            } else charsContainer[currentSymbol] = strCursor

            strCursor++
        }

        return largestSubstring
    }
}