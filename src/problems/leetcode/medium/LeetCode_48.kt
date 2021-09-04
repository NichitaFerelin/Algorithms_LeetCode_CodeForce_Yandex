package problems.leetcode.medium

class LeetCode_48 {

    fun rotate(matrix: Array<IntArray>): Unit {
        for (outIndex in matrix.indices) {
            for (inIndex in outIndex until matrix[0].size) {
                val temp = matrix[outIndex][inIndex]
                matrix[outIndex][inIndex] = matrix[inIndex][outIndex]
                matrix[inIndex][outIndex] = temp
            }
        }
        for (outIndex in matrix.indices) {
            for (inIndex in 0 until matrix.size / 2) {
                val temp = matrix[outIndex][inIndex]
                matrix[outIndex][inIndex] = matrix[outIndex][matrix.size - 1 - inIndex]
                matrix[outIndex][matrix.size - 1 - inIndex] = temp
            }
        }
    }
}