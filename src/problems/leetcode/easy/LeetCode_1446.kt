package problems.leetcode.easy

class LeetCode_1446 {

    fun maxPower(s: String): Int {
        var maxPower = 0

        var stepPower = 1
        var lastSymbol = ' '
        s.forEach { symbol ->
            if (lastSymbol == symbol) {
                stepPower++
            } else {
                if (stepPower > maxPower) {
                    maxPower = stepPower
                }
                stepPower = 1
            }
            lastSymbol = symbol
        }

        return if (maxPower == 1) 0 else maxPower
    }
}