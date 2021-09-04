package problems.leetcode.easy

class LeetCode_1812 {

    fun squareIsWhite(coordinates: String): Boolean {
        val column = when (coordinates[0]) {
            'a' -> 1
            'b' -> 2
            'c' -> 3
            'd' -> 4
            'e' -> 5
            'f' -> 6
            'g' -> 7
            else -> 8
        }
        val row = coordinates[1].toString().toInt()
        return (column + row) % 2 == 0
    }
}