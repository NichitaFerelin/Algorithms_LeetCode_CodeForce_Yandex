package problems.medium

import java.util.*

class LeetCode_542 {

    private val dirs = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
    )

    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val freeCells: Queue<Pair<Int, Int>> = LinkedList()

        mat.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, number ->
                if (number == 1) {
                    mat[rowIndex][columnIndex] = -1
                } else freeCells.offer(Pair(rowIndex, columnIndex))
            }
        }

        var length = 0
        while (freeCells.isNotEmpty()) {
            length++
            for (index in 0 until freeCells.size) {
                val currentCoordinates = freeCells.poll()
                val currentRow = currentCoordinates.first
                val currentColumn = currentCoordinates.second

                dirs.forEach {
                    val row = currentRow + it[0]
                    val column = currentColumn + it[1]

                    if (row >= 0 && row < mat.size
                        && column >= 0 && column < mat[row].size
                        && mat[row][column] == -1
                    ) {
                        mat[row][column] = length
                        freeCells.offer(Pair(row, column))
                    }
                }
            }
        }
        return mat
    }
}