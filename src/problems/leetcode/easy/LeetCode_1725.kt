package problems.leetcode.easy

class LeetCode_1725 {

    fun countGoodRectangles(rectangles: Array<IntArray>): Int {
        val squaresContainer = HashMap<Int, Int>(rectangles.size, 0.000001F)
        var maxLen = -1
        rectangles.forEach { rectArr ->
            val min = if (rectArr[0] > rectArr[1]) rectArr[1] else rectArr[0]

            if (min > maxLen) {
                maxLen = min
            }

            val atContainer = squaresContainer[min]
            if (atContainer == null) {
                squaresContainer[min] = 1
            } else squaresContainer[min] = atContainer + 1
        }

        return squaresContainer[maxLen] ?: 0
    }
}