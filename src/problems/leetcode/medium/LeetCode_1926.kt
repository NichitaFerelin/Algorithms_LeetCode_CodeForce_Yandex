package problems.leetcode.medium

import java.util.*


class LeetCode_1926 {

    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        val queue: Queue<IntArray> = LinkedList()
        val visited = Array(maze.size) { BooleanArray(maze[it].size) }

        var steps = 0

        queue.offer(entrance)
        visited[entrance[0]][entrance[1]] = true

        while (!queue.isEmpty()) {
            steps++
            val untilSize = queue.size

            for (index in 0 until untilSize) {
                val currentCoordinates = queue.poll()
                for (dir in dirs) {
                    val currentRow = dir[0] + currentCoordinates[0]
                    val currentColumn = dir[1] + currentCoordinates[1]

                    if (
                        currentRow < 0 || currentRow >= maze.size
                        || currentColumn < 0 || currentColumn >= maze[currentRow].size
                        || visited[currentRow][currentColumn]
                        || maze[currentRow][currentColumn] == '+'
                    ) continue

                    if (
                        currentRow == 0 || currentRow == maze.lastIndex
                        || currentColumn == 0 || currentColumn == maze[currentRow].lastIndex
                    ) return steps

                    queue.offer(intArrayOf(currentRow, currentColumn))
                    visited[currentRow][currentColumn] = true
                }
            }
        }
        return -1
    }
}