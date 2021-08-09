package problems.hard

class LeetCode_980 {

    var totalAvailablePaths = 0
    var emptyCells = 0

    fun uniquePathsIII(grid: Array<IntArray>): Int {
        var startX = 0
        var startY = 0
        grid.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, column ->
                if (grid[rowIndex][columnIndex] == 0) {
                    emptyCells++
                } else if (grid[rowIndex][columnIndex] == 1) {
                    emptyCells++
                    startX = columnIndex
                    startY = rowIndex
                }
            }
        }
        findPath(grid, startX, startY)
        return totalAvailablePaths
    }

    private fun findPath(grid: Array<IntArray>, currentX: Int, currentY: Int) {
        if (currentX < 0 || currentX >= grid[0].size || currentY < 0 || currentY >= grid.size || grid[currentY][currentX] < 0) {
            return
        }

        if (grid[currentY][currentX] == 2) {
            if (emptyCells == 0) {
                totalAvailablePaths++
            }

            return
        }

        grid[currentY][currentX] = -2
        emptyCells--

        findPath(grid, currentX - 1, currentY)
        findPath(grid, currentX + 1, currentY)
        findPath(grid, currentX, currentY - 1)
        findPath(grid, currentX, currentY + 1)

        grid[currentY][currentX] = 0
        emptyCells++
    }
}