package problems.leetcode.easy

class LeetCode_1796 {

    fun secondHighest(s: String): Int {
        var firstMax: Int? = null
        var secondMax: Int? = null

        s.forEach { symbol ->
            if (symbol.isDigit()) {
                val num = symbol.toString().toInt()
                if (secondMax == null || num > secondMax!!) {

                    if (firstMax == null || num > firstMax!!) {
                        secondMax = firstMax
                        firstMax = num
                    } else if (firstMax != num) secondMax = num
                }
            }
        }
        return secondMax ?: -1
    }
}