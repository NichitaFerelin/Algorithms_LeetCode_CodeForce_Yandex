package problems.easy

/**
 * You are given a string allowed consisting of distinct characters
 * and an array of strings words. A string is consistent if all
 * characters in the string appear in the string allowed.
 *
 * Return the number of consistent strings in the array words.
 * */

class LeetCode_1684 {

    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        val allowedContainer = HashMap<Char, Unit>(allowed.length, 0.000001F)
        allowed.forEach { allowedSymbol -> allowedContainer[allowedSymbol] = Unit }

        var allowedStrsCounter = 0
        words.forEach { word ->
            var isAllowed = true
            word.forEach { symbol ->
                if (allowedContainer[symbol] == null) {
                    isAllowed = false
                }
            }

            if (isAllowed) allowedStrsCounter++
        }

        return allowedStrsCounter
    }
}