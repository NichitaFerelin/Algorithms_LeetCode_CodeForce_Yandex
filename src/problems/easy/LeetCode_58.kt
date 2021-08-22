package problems.easy

class LeetCode_58 {

    fun lengthOfLastWord(s: String): Int {
        var strCursor = s.lastIndex
        while (strCursor >= 0 && !s[strCursor].isLetter()) {
            strCursor--
        }

        var resLength = 0
        if (strCursor >= 0) {
            while (strCursor >= 0 && s[strCursor].isLetter()) {
                resLength++
                strCursor--
            }
        }

        return resLength
    }
}