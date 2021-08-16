package problems.easy

class LeetCode_1582 {

    fun numSpecial(mat: Array<IntArray>): Int {
        val unitsMap = HashMap<Pair<Int, Int>, Unit>()
        val rowsSum = HashMap<Int, Int>()
        val colsSum = HashMap<Int, Int>()

        mat.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, number ->
                if (number == 1) {
                    unitsMap[Pair(rowIndex, colIndex)] = Unit
                }

                rowsSum[rowIndex] = rowsSum.getOrDefault(rowIndex, 0) + number
                colsSum[colIndex] = colsSum.getOrDefault(colIndex, 0) + number
            }
        }

        var totalSpecialUnits = 0
        unitsMap.keys.forEach {
            val rowIndex = it.first
            val colIndex = it.second
            if (rowsSum[rowIndex] == 1 && colsSum[colIndex] == 1) {
                totalSpecialUnits++
            }
        }

        return totalSpecialUnits
    }
}