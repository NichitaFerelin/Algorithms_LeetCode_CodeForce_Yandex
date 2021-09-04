package problems.leetcode.easy

class LeetCode_1629 {

    fun slowestKey(releaseTimes: IntArray, keysPressed: String): Char {
        var largestSymbol = keysPressed[0]
        var longestPress = releaseTimes[0]

        var arrCursor = 1
        while (arrCursor < keysPressed.length) {
            val currentSymbol = keysPressed[arrCursor]
            val pressDuration = releaseTimes[arrCursor] - releaseTimes[arrCursor - 1]

            if (pressDuration > longestPress) {
                longestPress = pressDuration
                largestSymbol = currentSymbol
            } else if (pressDuration == longestPress && currentSymbol > largestSymbol) {
                largestSymbol = currentSymbol
            }

            arrCursor++
        }

        return largestSymbol
    }
}