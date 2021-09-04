package problems.leetcode.easy

class LeetCode_999 {

    fun numRookCaptures(board: Array<CharArray>): Int {
        val target = 'p'
        var rookCaptures = 0

        var rookRow = 0
        var rookColumn = 0
        board.forEachIndexed { rowIndex, column ->
            column.forEachIndexed { columnIndex, symbol ->
                if (symbol == 'R') {
                    rookColumn = columnIndex
                    rookRow = rowIndex
                }
            }
        }

        var tempRow = rookRow - 1
        while (tempRow >= 0 && board[tempRow][rookColumn] == '.') {
            tempRow--
        }
        if (tempRow >= 0 && board[tempRow][rookColumn] == target) rookCaptures++

        tempRow = rookRow + 1
        while (tempRow < board.size && board[tempRow][rookColumn] == '.') {
            tempRow++
        }
        if (tempRow < board.size && board[tempRow][rookColumn] == target) rookCaptures++

        var tempColumn = rookColumn + 1
        while (tempColumn < board[rookRow].size && board[rookRow][tempColumn] == '.') {
            tempColumn++
        }
        if (tempColumn < board[rookRow].size && board[rookRow][tempColumn] == target) rookCaptures++

        tempColumn = rookColumn - 1
        while (tempColumn >= 0 && board[rookRow][tempColumn] == '.') {
            tempColumn--
        }
        if (tempColumn >= 0 && board[rookRow][tempColumn] == target) rookCaptures++

        return rookCaptures
    }
}