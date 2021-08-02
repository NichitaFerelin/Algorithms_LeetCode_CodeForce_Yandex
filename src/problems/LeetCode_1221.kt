package problems

/**
 * Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
 * Given a balanced string s, split it in the maximum amount of balanced strings.
 * Return the maximum amount of split balanced strings.
 * */

class LeetCode_1221 {

    fun balancedStringSplit(s: String): Int {
        var totalCounter = 0
        var lCounter = 0
        var rCounter = 0
        s.forEach { symbol ->
            if (symbol == 'R') {
                rCounter++
            } else lCounter++

            if (lCounter == rCounter) {
                totalCounter++
                rCounter = 0
                lCounter = 0
            }
        }

        return totalCounter
    }
}