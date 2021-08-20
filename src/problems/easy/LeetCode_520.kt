package problems.easy

class LeetCode_520 {
    fun detectCapitalUse(word: String): Boolean {
        var containsLowerCase = false
        var upperCaseIsOnlyFirst = false

        val firstSymbol = word[0]
        if (firstSymbol.isUpperCase()) upperCaseIsOnlyFirst = true else containsLowerCase = true

        for (index in 1 until word.length) {
            val currentSymbol = word[index]
            if (currentSymbol.isUpperCase()) {
                if (containsLowerCase) {
                    return false
                }
                upperCaseIsOnlyFirst = false
            } else {
                if (!upperCaseIsOnlyFirst) {
                    return false
                }
                containsLowerCase = true
            }
        }

        return true
    }
}