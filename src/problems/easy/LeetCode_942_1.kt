package problems.easy

class LeetCode_942_1 {

    fun diStringMatch(s: String): IntArray {
        val result = IntArray(s.length + 1)
        var resultArrCursor = 0

        var maxCursor = s.length
        var minCursor = 0

        s.forEach { symbol -> result[resultArrCursor++] = if (symbol == 'I') minCursor++ else maxCursor-- }
        result[resultArrCursor] = if(s[s.lastIndex] == 'D') minCursor else maxCursor
        return result
    }
}