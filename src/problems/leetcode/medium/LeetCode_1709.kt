package problems.leetcode.medium


class LeetCode_1709 {

    var count = 0

    fun numTilePossibilities(tiles: String): Int {
        val charsOfStr = tiles.toCharArray().sortedArray()
        val visited = BooleanArray(charsOfStr.size)
        dfs(charsOfStr, 0, visited)
        return count
    }

    private fun dfs(chars: CharArray, length: Int, visited: BooleanArray) {
        if (length == chars.size) {
            return
        }

        for (index in chars.indices) {
            if (visited[index]) {
                continue
            }

            if (index - 1 >= 0 && chars[index] == chars[index - 1] && !visited[index - 1]) {
                continue
            }

            count++
            visited[index] = true
            dfs(chars, length + 1, visited)
            visited[index] = false
        }
    }
}