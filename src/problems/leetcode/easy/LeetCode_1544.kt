package problems.leetcode.easy

class LeetCode_1544 {

    fun makeGood(s: String): String {
        val builder = StringBuilder(s)
        var cursor = 0
        while (builder.length > 1 && cursor < builder.length - 1) {
            val currentSymbol = builder[cursor]
            val nextSymbol = builder[cursor + 1]

            if (
                currentSymbol.equals(nextSymbol, ignoreCase = true) &&
                ((currentSymbol.isLowerCase() && nextSymbol.isUpperCase())
                        || (currentSymbol.isUpperCase() && nextSymbol.isLowerCase()))
            ) {
                builder.deleteCharAt(cursor)
                builder.deleteCharAt(cursor)
                cursor = 0
            } else cursor++
        }

        return builder.toString()
    }
}