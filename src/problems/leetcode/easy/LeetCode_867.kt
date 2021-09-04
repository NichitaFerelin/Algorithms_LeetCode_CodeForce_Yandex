package problems.leetcode.easy

class LeetCode_867 {

    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val result = Array(matrix[0].size) { IntArray(matrix.size) }
        var resultRowCursor = 0
        var resultColCursor = 0

        var matrixRowCursor = 0
        var matrixColCursor = 0
        while (matrixColCursor < matrix[0].size) {
            while (matrixRowCursor < matrix.size) {
                result[resultRowCursor][resultColCursor] = matrix[matrixRowCursor][matrixColCursor]
                resultColCursor++
                matrixRowCursor++
            }
            matrixRowCursor = 0
            resultColCursor = 0
            matrixColCursor++
            resultRowCursor++
        }

        return result
    }
}