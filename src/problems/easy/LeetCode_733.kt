package problems.easy

class LeetCode_733 {

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val initialColor = image[sr][sc]
        fill(HashMap(), image, sr, sc, initialColor, newColor)
        return image
    }

    private fun fill(
        filled: HashMap<String, Unit>,
        grid: Array<IntArray>,
        currentRow: Int,
        currentColumn: Int,
        initialColor: Int,
        newColor: Int
    ) {
        val key = "$currentRow-$currentColumn"
        if (filled[key] != null
            || currentRow < 0 || currentRow >= grid.size
            || currentColumn < 0 || currentColumn >= grid[currentRow].size
            || grid[currentRow][currentColumn] != initialColor
        ) return

        filled[key] = Unit
        grid[currentRow][currentColumn] = newColor

        fill(filled, grid, currentRow + 1, currentColumn, initialColor, newColor)
        fill(filled, grid, currentRow - 1, currentColumn, initialColor, newColor)
        fill(filled, grid, currentRow, currentColumn + 1, initialColor, newColor)
        fill(filled, grid, currentRow, currentColumn - 1, initialColor, newColor)
    }
}