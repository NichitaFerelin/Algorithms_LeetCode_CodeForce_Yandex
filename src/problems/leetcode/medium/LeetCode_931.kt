package problems.leetcode.medium

class LeetCode_931 {

    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        if (matrix.size == 1) {
            var min = Int.MAX_VALUE
            matrix[0].forEach { if (it < min) min = it }
            return min
        }

        val dp = Array(matrix.size) { IntArray(matrix[it].size) { Int.MAX_VALUE } }
        for (columnIndex in matrix[0].indices) {
            dp[0][columnIndex] = matrix[0][columnIndex]
        }

        for (rowIndex in 1 until matrix.size - 1) {
            for (columnIndex in matrix[rowIndex].indices) {
                fillDp(matrix, dp, rowIndex, columnIndex)
            }
        }

        var min = dp[dp.lastIndex][0]
        for (columnIndex in matrix[matrix.lastIndex].indices) {
            val resultValue = fillDp(matrix, dp, matrix.lastIndex, columnIndex)
            if (resultValue < min) {
                min = resultValue
            }
        }
        return min
    }

    private fun fillDp(
        matrix: Array<IntArray>,
        dp: Array<IntArray>,
        rowIndex: Int,
        columnIndex: Int
    ): Int {
        val topLeftValue = dp[rowIndex - 1].getOrNull(columnIndex - 1) ?: Int.MAX_VALUE
        val topValue = dp[rowIndex - 1].getOrNull(columnIndex) ?: Int.MAX_VALUE
        val topRightValue = dp[rowIndex - 1].getOrNull(columnIndex + 1) ?: Int.MAX_VALUE

        val minFromTop = minOf(topLeftValue, topValue, topRightValue) + matrix[rowIndex][columnIndex]
        dp[rowIndex][columnIndex] = if (dp[rowIndex][columnIndex] < minFromTop) {
            dp[rowIndex][columnIndex]
        } else {
            minFromTop
        }

        return dp[rowIndex][columnIndex]
    }
}