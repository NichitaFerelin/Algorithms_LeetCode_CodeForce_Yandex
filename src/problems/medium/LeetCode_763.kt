package problems.medium

/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Return a list of integers representing the size of these parts.
 * */

class LeetCode_763 {

    fun partitionLabels(s: String): List<Int> {
        val positionsContainer = HashMap<Char, Int>(26)
        s.forEachIndexed { index, symbol -> positionsContainer[symbol] = index }

        val result = mutableListOf<Int>()
        var strCursor = 0
        while (strCursor < s.length) {
            val currentSymbol = s[strCursor]
            val lastSymbolPosition = positionsContainer[currentSymbol]!!
            val partitionStart = strCursor
            var partitionStop = lastSymbolPosition

            var inRangeCursor = partitionStart + 1
            while (inRangeCursor < partitionStop) {
                val inRangeSymbol = s[inRangeCursor]
                val lastInRangeSymPosition = positionsContainer[inRangeSymbol]!!

                if (lastInRangeSymPosition > partitionStop) {
                    partitionStop = lastInRangeSymPosition
                }
                inRangeCursor++
            }

            result.add(partitionStop - partitionStart + 1)
            strCursor = partitionStop + 1
        }

        return result
    }
}