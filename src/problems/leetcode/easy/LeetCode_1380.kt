package problems.leetcode.easy

class LeetCode_1380 {

    fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
        val minRowsContainer = HashMap<Int, Unit>()
        val maxColsContainer = HashMap<Int, Unit>()

        var rowCursor = 0
        var colCursor = 0
        while (rowCursor < matrix.size) {
            var min = Int.MAX_VALUE
            while (colCursor < matrix[rowCursor].size) {
                if (matrix[rowCursor][colCursor] < min) {
                    min = matrix[rowCursor][colCursor]
                }
                colCursor++
            }
            colCursor = 0
            minRowsContainer[min] = Unit
            rowCursor++
        }

        rowCursor = 0
        colCursor = 0
        while (colCursor < matrix[rowCursor].size) {
            var max = Int.MIN_VALUE
            while (rowCursor < matrix.size) {
                if (matrix[rowCursor][colCursor] > max) {
                    max = matrix[rowCursor][colCursor]
                }
                rowCursor++
            }
            maxColsContainer[max] = Unit
            rowCursor = 0
            colCursor++
        }

        val luckyNumbers = mutableListOf<Int>()
        minRowsContainer.keys.forEach { minNumAtRow ->
            if (maxColsContainer[minNumAtRow] != null) {
                luckyNumbers.add(minNumAtRow)
            }
        }
        return luckyNumbers
    }
}