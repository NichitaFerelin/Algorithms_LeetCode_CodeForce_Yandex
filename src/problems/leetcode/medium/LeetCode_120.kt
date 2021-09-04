package problems.leetcode.medium

class LeetCode_120 {

    fun minimumTotal(triangle: List<List<Int>>): Int {
        if (triangle.size == 1) return triangle[0][0]

        val dp = Array(triangle.size) { IntArray(triangle[it].size) { Int.MAX_VALUE } }
        dp[0][0] = triangle[0][0]

        for (rowIndex in 0 until dp.size - 1) {
            for (columnIndex in 0 until dp[rowIndex].size) {
                dp[rowIndex + 1][columnIndex] = minOf(
                    dp[rowIndex + 1][columnIndex],
                    dp[rowIndex][columnIndex] + triangle[rowIndex + 1][columnIndex]
                )
                dp[rowIndex + 1][columnIndex + 1] = minOf(
                    dp[rowIndex + 1][columnIndex + 1],
                    dp[rowIndex][columnIndex] + triangle[rowIndex + 1][columnIndex + 1]
                )
            }
        }

        var min: Int? = null
        for (index in 0 until dp[dp.lastIndex].size) {
            if (min == null || dp[dp.lastIndex][index] < min) {
                min = dp[dp.lastIndex][index]
            }
        }
        return min!!
    }
}