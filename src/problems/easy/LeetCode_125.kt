package problems.easy

class LeetCode_125 {

    fun isPalindrome(s: String): Boolean {
        return when (s.length) {
            1 -> true
            2 -> {
                if (s[0].isLetterOrDigit() && s[1].isLetterOrDigit()) {
                    s[0].toLowerCase() == s[1].toLowerCase()
                } else true
            }
            else -> {
                var leftCursor = 0
                var rightCursor = s.lastIndex

                while (leftCursor < rightCursor) {

                    while (leftCursor < rightCursor && !s[leftCursor].isLetterOrDigit()) {
                        leftCursor++
                    }
                    while (rightCursor > leftCursor && !s[rightCursor].isLetterOrDigit()) {
                        rightCursor--
                    }

                    val leftSymbol = s[leftCursor].toLowerCase()
                    val rightSymbol = s[rightCursor].toLowerCase()

                    if (leftSymbol != rightSymbol) return false

                    leftCursor++
                    rightCursor--
                }

                return true
            }
        }
    }
}