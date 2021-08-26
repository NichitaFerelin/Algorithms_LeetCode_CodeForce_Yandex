package problems.medium

class LeetCode_695 {

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val exploredIslands = HashMap<String, Unit>()
        var maxArea = 0

        grid.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, num ->
                if (num == 1) {
                    val areaOfIsland = fillAsExplored(exploredIslands, grid, rowIndex, columnIndex)
                    if (areaOfIsland > maxArea) {
                        maxArea = areaOfIsland
                    }
                }
            }
        }

        return maxArea
    }

    private fun fillAsExplored(
        map: HashMap<String, Unit>,
        grid: Array<IntArray>,
        currentRow: Int,
        currentColumn: Int
    ): Int {
        val key = "$currentRow-$currentColumn"

        if (map[key] != null
            || currentRow < 0 || currentRow >= grid.size
            || currentColumn < 0 || currentColumn >= grid[currentRow].size
            || grid[currentRow][currentColumn] != 1
        ) return 0

        map[key] = Unit

        var area = 1

        area += fillAsExplored(map, grid, currentRow + 1, currentColumn)
        area += fillAsExplored(map, grid, currentRow - 1, currentColumn)
        area += fillAsExplored(map, grid, currentRow, currentColumn + 1)
        area += fillAsExplored(map, grid, currentRow, currentColumn - 1)

        return area
    }
}