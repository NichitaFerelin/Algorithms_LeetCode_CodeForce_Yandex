package problems.easy

class LeetCode_119 {

    fun getRow(rowIndex: Int): List<Int> {
        val res = IntArray(rowIndex + 1)
        res[0] = 1
        for (outIndex in 1 until res.size) {
            for (inIndex in outIndex downTo 1) {
                res[inIndex] = res[inIndex] + res[inIndex - 1]
            }
        }
        return res.toList()
    }
}