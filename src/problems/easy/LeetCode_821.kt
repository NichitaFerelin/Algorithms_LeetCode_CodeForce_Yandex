package problems.easy

class LeetCode_821 {

    fun shortestToChar(s: String, c: Char): IntArray {
        val targetIndexes = mutableListOf<Int>()
        s.forEachIndexed { index, symbol ->
            if (symbol == c) {
                targetIndexes.add(index)
            }
        }
        return IntArray(s.length) { index ->
            var min = Int.MAX_VALUE
            var minIndex = -1
            targetIndexes.forEachIndexed { targetIndex, num ->
                val distance = kotlin.math.abs(num - index)
                if (distance < min) {
                    min = distance
                    minIndex = targetIndex
                }
            }
            min
        }
    }
}