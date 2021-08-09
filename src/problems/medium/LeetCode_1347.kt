package problems.medium

class LeetCode_1347 {

    fun minSteps(s: String, t: String): Int {
        var totalSteps = 0

        val charsContainer = HashMap<Char, Int>(s.length + t.length)
        s.forEach { symbol -> charsContainer[symbol] = charsContainer.getOrDefault(symbol, 0) + 1 }

        t.forEach { tSymbol ->
            if (charsContainer[tSymbol] != null && charsContainer[tSymbol]!! > 0) {
                charsContainer[tSymbol] = charsContainer[tSymbol]!! - 1
            } else totalSteps++
        }

        return totalSteps
    }
}