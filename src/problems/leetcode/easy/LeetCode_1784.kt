package problems.leetcode.easy

class LeetCode_1784 {

    fun checkOnesSegment(s: String): Boolean {
        var alreadyWasSegment = false
        var strCursor = 0

        while (strCursor < s.length) {
            if (s[strCursor] == '1') {
                if (alreadyWasSegment) {
                    return false
                } else {
                    alreadyWasSegment = true
                    strCursor++
                    while (strCursor < s.length && s[strCursor] == '1') {
                        strCursor++
                    }
                }
            } else strCursor++
        }
        return true
    }
}