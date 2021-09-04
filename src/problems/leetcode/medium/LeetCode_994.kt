package problems.leetcode.medium

import java.util.*

class LeetCode_994 {

    private val dirs = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
    )

    fun orangesRotting(mat: Array<IntArray>): Int {
        val badCells: Queue<Pair<Int, Int>> = LinkedList()
        var freshCount = 0

        mat.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, number ->
                if (number == 1) {
                    freshCount++
                } else if (number == 2) badCells.offer(Pair(rowIndex, columnIndex))
            }
        }

        if (freshCount == 0) return 0

        var length = 0
        while (badCells.isNotEmpty()) {
            length++
            for (index in 0 until badCells.size) {
                val currentCoordinates = badCells.poll()
                val currentRow = currentCoordinates.first
                val currentColumn = currentCoordinates.second

                dirs.forEach {
                    val row = currentRow + it[0]
                    val column = currentColumn + it[1]

                    if (row >= 0 && row < mat.size
                        && column >= 0 && column < mat[row].size
                        && mat[row][column] == 1
                    ) {
                        mat[row][column] = 2
                        badCells.offer(Pair(row, column))
                        freshCount--
                    }
                }
            }
        }
        return if (freshCount == 0) length - 1 else -1
    }
}