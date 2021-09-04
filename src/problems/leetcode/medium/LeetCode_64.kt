package problems.leetcode.medium

class LeetCode_64 {

    fun minPathSum(grid: Array<IntArray>): Int {
        val dp = Array(grid.size) { IntArray(grid[it].size) }

        dp[0][0] = grid[0][0]
        for (index in 1 until dp.size) dp[index][0] = dp[index - 1][0] + grid[index][0]
        for (index in 1 until dp[0].size) dp[0][index] = dp[0][index - 1] + grid[0][index]

        for (rowIndex in 1 until dp.size) {
            for (columnIndex in 1 until dp[rowIndex].size) {
                dp[rowIndex][columnIndex] = minOf(
                    dp[rowIndex - 1][columnIndex],
                    dp[rowIndex][columnIndex - 1]
                ) + grid[rowIndex][columnIndex]
            }
        }
        return dp[dp.lastIndex][dp[dp.lastIndex].lastIndex]
    }
}