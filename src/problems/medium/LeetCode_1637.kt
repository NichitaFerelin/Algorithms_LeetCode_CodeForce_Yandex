package problems.medium

class LeetCode_1637 {

    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        val sortedPoints = points.sortedBy { it[0] }
        var widestArea = 0
        for (index in 1 until sortedPoints.size) {
            val width = sortedPoints[index][0] - sortedPoints[index - 1][0]
            if (width > widestArea) {
                widestArea = width
            }
        }
        return widestArea
    }
}