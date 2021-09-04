package problems.leetcode.medium

class LeetCode_1314 {

    fun matrixBlockSum(mat: Array<IntArray>, k: Int): Array<IntArray> {
        val result = Array(mat.size) { index -> IntArray(mat[index].size) }
        mat.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, number ->
                val rStart = rowIndex - k
                val rEnd = rowIndex + k
                val cStart = columnIndex - k
                val cEnd = columnIndex + k

                var rCursor = rStart
                var cCursor = cStart

                var resSum = 0
                while (rCursor <= rEnd) {
                    if (rCursor >= 0 && rCursor < mat.size) {
                        while (cCursor <= cEnd) {
                            if (cCursor >= 0 && cCursor < row.size) {
                                resSum += mat[rCursor][cCursor]
                            }
                            cCursor++
                        }
                        cCursor = cStart
                    }
                    rCursor++
                }
                result[rowIndex][columnIndex] = resSum
            }
        }

        return result
    }
}