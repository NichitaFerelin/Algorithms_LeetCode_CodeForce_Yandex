package problems.medium

class LeetCode_419 {

    fun countBattleships(board: Array<CharArray>): Int {
        val exploredContainer = HashMap<String, Unit>(board.size * board[0].size)
        var ships = 0

        var rowCursor = 0
        while (rowCursor < board.size) {

            var columnCursor = 0
            while (columnCursor < board[rowCursor].size) {
                val currentCellSymbol = board[rowCursor][columnCursor]
                val currentCellKey = "$rowCursor-$columnCursor"

                if (exploredContainer[currentCellKey] == Unit) {
                    columnCursor++
                    continue
                }

                if (currentCellSymbol == '.') {
                    exploredContainer[currentCellKey] = Unit
                    columnCursor++
                    continue
                }

                ships++

                var tempRowCursor = rowCursor
                while (tempRowCursor >= 0 && board[tempRowCursor][columnCursor] == 'X') {
                    val cellKey = "$tempRowCursor-$columnCursor"

                    if (tempRowCursor != rowCursor) {
                        val left = columnCursor - 1
                        val right = columnCursor + 1
                        val cellLeftKey = "$tempRowCursor-$left"
                        val cellRightKey = "$tempRowCursor-$right"
                        exploredContainer[cellLeftKey] = Unit
                        exploredContainer[cellRightKey] = Unit
                    }

                    exploredContainer[cellKey] = Unit
                    tempRowCursor--
                }

                tempRowCursor = rowCursor
                while (tempRowCursor < board.size && board[tempRowCursor][columnCursor] == 'X') {
                    val cellKey = "$tempRowCursor-$columnCursor"

                    if (tempRowCursor != rowCursor) {
                        val left = columnCursor - 1
                        val right = columnCursor + 1
                        val cellLeftKey = "$tempRowCursor-$left"
                        val cellRightKey = "$tempRowCursor-$right"
                        exploredContainer[cellLeftKey] = Unit
                        exploredContainer[cellRightKey] = Unit
                    }

                    exploredContainer[cellKey] = Unit
                    tempRowCursor++
                }

                var tempColumnCursor = columnCursor
                while (tempColumnCursor >= 0 && board[rowCursor][tempColumnCursor] == 'X') {
                    val cellKey = "$tempRowCursor-$columnCursor"

                    if (tempColumnCursor != columnCursor) {
                        val top = rowCursor + 1
                        val bottom = rowCursor - 1
                        val cellTopKey = "$top-$tempColumnCursor"
                        val cellBottomKey = "$bottom-$tempColumnCursor"
                        exploredContainer[cellTopKey] = Unit
                        exploredContainer[cellBottomKey] = Unit
                    }

                    exploredContainer[cellKey] = Unit
                    tempColumnCursor--
                }

                tempColumnCursor = columnCursor
                while (tempColumnCursor < board[rowCursor].size && board[rowCursor][tempColumnCursor] == 'X') {
                    val cellKey = "$tempRowCursor-$columnCursor"

                    if (tempColumnCursor != columnCursor) {
                        val top = rowCursor + 1
                        val bottom = rowCursor - 1
                        val cellTopKey = "$top-$tempColumnCursor"
                        val cellBottomKey = "$bottom-$tempColumnCursor"
                        exploredContainer[cellTopKey] = Unit
                        exploredContainer[cellBottomKey] = Unit
                    }

                    exploredContainer[cellKey] = Unit
                    tempColumnCursor++
                }
                columnCursor = tempColumnCursor
            }
            rowCursor++
        }

        return ships
    }
}