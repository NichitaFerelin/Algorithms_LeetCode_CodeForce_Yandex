package problems.medium

class LeetCode_62 {

    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) }
        for (index in 0 until dp[0].size) dp[0][index] = 1
        for (index in dp.indices) dp[index][0] = 1

        for (rowIndex in 1 until dp.size) {
            for (columnIndex in 1 until dp[rowIndex].size) {
                dp[rowIndex][columnIndex] = dp[rowIndex - 1][columnIndex] + dp[rowIndex][columnIndex - 1]
            }
        }
        return dp[m - 1][n - 1]
    }
}