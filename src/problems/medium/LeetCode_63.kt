package problems.medium

class LeetCode_63 {

    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val dp = Array(obstacleGrid.size) { IntArray(obstacleGrid[it].size) }
        dp[0][0] = if (obstacleGrid[0][0] == 1) 0 else 1

        for (index in 1 until dp[0].size) {
            if (obstacleGrid[0][index] == 1) {
                dp[0][index] = 0
            } else dp[0][index] = dp[0][index - 1]
        }

        for (index in 1 until dp.size) {
            if (obstacleGrid[index][0] == 1) {
                dp[index][0] = 0
            } else dp[index][0] = dp[index - 1][0]
        }

        for (rowIndex in 1 until dp.size) {
            for (columnIndex in 1 until dp[rowIndex].size) {
                dp[rowIndex][columnIndex] = if (obstacleGrid[rowIndex][columnIndex] != 1) {
                    dp[rowIndex - 1][columnIndex] + dp[rowIndex][columnIndex - 1]
                } else 0
            }
        }
        return dp[dp.lastIndex][dp[dp.lastIndex].lastIndex]
    }
}