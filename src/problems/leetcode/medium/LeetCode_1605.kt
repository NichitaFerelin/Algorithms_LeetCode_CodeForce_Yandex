package problems.leetcode.medium

class LeetCode_1605 {

    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val rowsSumContainer = HashMap<Int, Int>(rowSum.size)
        val colsSumContainer = HashMap<Int, Int>(colSum.size)

        return Array(rowSum.size) { outIndex ->
            IntArray(colSum.size) { inIndex ->
                val currentRowSum = rowsSumContainer[outIndex] ?: 0
                val currentColSum = colsSumContainer[inIndex] ?: 0

                val rowSumMustBe = rowSum[outIndex]
                val colSumMustBe = colSum[inIndex]

                val maxToIncrease = minOf(rowSumMustBe, colSumMustBe)
                rowSum[outIndex] -= maxToIncrease
                colSum[inIndex] -= maxToIncrease

                rowsSumContainer[outIndex] = currentRowSum + maxToIncrease
                colsSumContainer[inIndex] = currentColSum + maxToIncrease

                maxToIncrease
            }
        }
    }

    fun minOf(vararg args: Int): Int {
        var min = args.first()
        args.forEach { if (it < min) min = it }
        return min
    }
}