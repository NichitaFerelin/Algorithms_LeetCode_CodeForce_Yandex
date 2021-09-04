package problems.leetcode.easy

class LeetCode_806 {

    fun numberOfLines(widths: IntArray, s: String): IntArray {
        val limit = 100

        var totalLines = 0

        var currentLinePixels = 0
        s.forEach { symbol ->
            val pixelsForSymbol = widths[kotlin.math.abs(symbol.toInt() - 97)]
            if (currentLinePixels + pixelsForSymbol > limit) {
                currentLinePixels = pixelsForSymbol
                totalLines++
            } else currentLinePixels += pixelsForSymbol
        }

        return intArrayOf(++totalLines, currentLinePixels)
    }
}