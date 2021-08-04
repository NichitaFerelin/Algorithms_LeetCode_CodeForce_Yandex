package problems.easy

class LeetCode_1252 {

    fun oddCells(m: Int, n: Int, indices: Array<IntArray>): Int {
        val incRowsContainer = HashMap<Int, Int>(101, 0.00001F)
        val incColsContainer = HashMap<Int, Int>(101, 0.00001F)
        indices.forEach { arr ->
            val rowToIncrement = arr[0]
            val incRowAtContainer = incRowsContainer[rowToIncrement]
            if (incRowAtContainer == null) {
                incRowsContainer[rowToIncrement] = 1
            } else incRowsContainer[rowToIncrement] = incRowAtContainer + 1

            val columnToIncrement = arr[1]
            val incColumnAtContainer = incColsContainer[columnToIncrement]
            if (incColumnAtContainer == null) {
                incColsContainer[columnToIncrement] = 1
            } else incColsContainer[columnToIncrement] = incColumnAtContainer + 1
        }

        var oddsCounter = 0
        for (outIndex in 0 until m) {
            for (inIndex in 0 until n) {
                val incByRow = incRowsContainer[outIndex] ?: 0
                val incByColumn = incColsContainer[inIndex] ?: 0
                if ((incByRow + incByColumn) % 2 != 0) {
                    oddsCounter++
                }
            }
        }

        return oddsCounter
    }
}