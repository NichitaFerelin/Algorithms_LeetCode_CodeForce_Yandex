package problems.easy

class LeetCode_118 {

    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        var currentRow = 0

        while (currentRow < numRows) {
            val resultRow = when (currentRow) {
                0 -> listOf(1)
                1 -> listOf(1, 1)
                else -> {
                    val currentList = IntArray(currentRow + 1)
                    currentList[0] = 1
                    currentList[currentList.lastIndex] = 1

                    val listBefore = result[currentRow - 1]

                    var listCursor = 1
                    while (listCursor < currentList.size - 1) {
                        currentList[listCursor] = listBefore[listCursor - 1] + listBefore[listCursor]
                        listCursor++
                    }

                    currentList.toList()
                }
            }
            result.add(resultRow)
            currentRow++
        }

        return result
    }
}