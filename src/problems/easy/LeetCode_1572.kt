package problems.easy

class LeetCode_1572 {

    fun diagonalSum(mat: Array<IntArray>): Int {
        var rowCursor = 0
        var columnCursor = 0

        var sum = 0
        while (columnCursor < mat[0].size) {
            sum += mat[rowCursor][columnCursor] + mat[mat.size - rowCursor - 1][columnCursor]
            columnCursor++
            rowCursor++
        }

        if (mat.size % 2 != 0) {
            sum -= mat[mat.size / 2][mat[0].size / 2]
        }

        return sum
    }
}