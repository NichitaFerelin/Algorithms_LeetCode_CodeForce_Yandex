package problems.leetcode.easy

class LeetCode_1337 {

    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val result = mutableListOf<Pair<Int, Int>>()

        mat.forEachIndexed { rowIndex, row ->
            val soldiersAtRow = row.count { it == 1 }
            val newPair = Pair(rowIndex, soldiersAtRow)
            if (result.isEmpty()) {
                result.add(newPair)
            } else {
                var positionToInsert = 0
                while (positionToInsert < result.size && result[positionToInsert].second <= newPair.second) {
                    positionToInsert++
                }
                result.add(positionToInsert, newPair)
            }
        }

        return IntArray(k) { index -> result[index].first }
    }
}