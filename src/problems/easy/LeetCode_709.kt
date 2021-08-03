package problems.easy

/**
 * Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
 * */

class LeetCode_709 {

    fun toLowerCase(s: String): String {
        val builder = StringBuilder(s)
        builder.forEachIndexed { index, symbol ->
            if (symbol.isUpperCase()) {
                builder[index] = symbol.toLowerCase()
            }
        }
        return builder.toString()
    }
}