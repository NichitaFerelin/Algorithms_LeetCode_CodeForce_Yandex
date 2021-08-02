package problems.medium

/**
 * There is a city composed of n x n blocks, where each block contains a single building shaped like a
 * vertical square prism. You are given a 0-indexed n x n integer matrix grid where grid[r][c] represents the
 * height of the building located in the block at row r and column c.
 *
 * A city's skyline is the the outer contour formed by all the building when viewing the side of the city from
 * a distance. The skyline from each cardinal direction north, east, south, and west may be different.
 *
 * We are allowed to increase the height of any number of buildings by any amount (the amount can be
 * different per building). The height of a 0-height building can also be increased. However, increasing
 * the height of a building should not affect the city's skyline from any cardinal direction.
 *
 * Return the maximum total sum that the height of the buildings can be increased by without
 * changing the city's skyline from any cardinal direction.
 * */

class LeetCode_807 {

    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        val nullValue = -1
        val columnsMaxsContainer = IntArray(grid[0].size) { nullValue }
        val rowsMaxsContainer = IntArray(grid.size) { nullValue }

        var total = 0

        grid.forEachIndexed { rowIndex, columns ->

            var maxRowHeight = rowsMaxsContainer[rowIndex]
            if (maxRowHeight == nullValue) {
                var maxHeight = 0
                var columnCursor = 0
                while (columnCursor < columns.size) {
                    if (columns[columnCursor] > maxHeight) {
                        maxHeight = columns[columnCursor]
                    }
                    columnCursor++
                }
                maxRowHeight = maxHeight
                rowsMaxsContainer[rowIndex] = maxHeight
            }

            columns.forEachIndexed { columnIndex, height ->
                var maxColumnHeight = columnsMaxsContainer[columnIndex]
                if (maxColumnHeight == nullValue) {
                    var maxHeight = 0
                    var rowCursor = 0
                    while (rowCursor < grid.size) {
                        if (grid[rowCursor][columnIndex] > maxHeight) {
                            maxHeight = grid[rowCursor][columnIndex]
                        }
                        rowCursor++
                    }
                    maxColumnHeight = maxHeight
                    columnsMaxsContainer[columnIndex] = maxHeight
                }

                val heightToIncrease = minOf(maxColumnHeight, maxRowHeight) - height
                total += heightToIncrease
            }
        }

        return total
    }
}