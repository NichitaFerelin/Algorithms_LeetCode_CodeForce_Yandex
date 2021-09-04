package problems.leetcode.easy

class LeetCode_766 {

    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        var rowCursor = matrix.lastIndex
        var colCursor = 0

        while (rowCursor >= 0 && colCursor < matrix[rowCursor].size) {
            val lastNum = matrix[rowCursor][colCursor]
            var tempRowCursor = rowCursor + 1
            var tempColCursor = colCursor + 1

            while (tempRowCursor < matrix.size && tempColCursor < matrix[rowCursor].size) {
                if (matrix[tempRowCursor][tempColCursor] != lastNum) {
                    return false
                }
                tempRowCursor++
                tempColCursor++
            }

            if (rowCursor > 0) {
                rowCursor--
            } else colCursor++
        }

        return true
    }
}