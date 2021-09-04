package problems.leetcode.hard

class LeetCode_44 {

    fun isMatch(s: String, p: String): Boolean {
        if (p.isEmpty()) return s.isEmpty()
        if (s.isEmpty()) return p.isNotEmpty() && p[0] == '*'

        var pCursor = 0
        var strCursor = 0
        while (strCursor < s.length) {
            if (pCursor >= p.length) return false

            val currentRule = p[pCursor]
            when (currentRule) {
                '*' -> {
                    pCursor++
                    while (pCursor < p.length && !p[pCursor].isLetter()) {
                        pCursor++
                    }

                    if (pCursor < p.length) {
                        val stopLetter = p[pCursor]

                        while (strCursor < s.length && s[strCursor] != stopLetter) {
                            strCursor++
                        }
                    } else strCursor = s.length
                }
                '?' -> {
                    strCursor++
                    pCursor++
                }
                else -> {
                    if (s[strCursor] != currentRule) return false
                    strCursor++
                    pCursor++
                }
            }
        }

        return pCursor >= p.length
    }
}