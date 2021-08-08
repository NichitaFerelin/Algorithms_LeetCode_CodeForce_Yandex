package problems.easy

class LeetCode_657 {

    fun judgeCircle(moves: String): Boolean {
        var x = 0
        var y = 0
        moves.forEach { move ->
            when (move) {
                'U' -> y++
                'D' -> y--
                'L' -> x--
                else -> x++
            }
        }

        return x == 0 && y == 0
    }
}