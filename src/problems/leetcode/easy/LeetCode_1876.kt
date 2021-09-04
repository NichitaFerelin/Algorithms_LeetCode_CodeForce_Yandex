package problems.leetcode.easy

class LeetCode_1876 {

    fun countGoodSubstrings(s: String): Int {
        var goodStrings = 0

        var strCursor = 0
        while (strCursor < s.length - 2) {
            val currentSubString = s.substring(strCursor, strCursor + 3)
            if (currentSubString.toCharArray().toSet().size == 3) {
                goodStrings++
            }
            strCursor++
        }

        return goodStrings
    }
}