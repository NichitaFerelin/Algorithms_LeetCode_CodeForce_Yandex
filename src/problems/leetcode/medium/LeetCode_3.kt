package problems.leetcode.medium

class LeetCode_3 {

    fun lengthOfLongestSubstring(s: String): Int {
        var longestSubstringCounter = 0
        var strCursor = 0
        while (strCursor < s.length) {
            val charsContainer = HashMap<Char, Unit>()
            var substringCounter = 0
            for (index in strCursor until s.length) {
                val currentChar = s[index]
                if (charsContainer[currentChar] == null) {
                    charsContainer[currentChar] = Unit
                    substringCounter++
                } else break
            }

            if (substringCounter > longestSubstringCounter) {
                longestSubstringCounter = substringCounter
            }
            strCursor++
        }

        return longestSubstringCounter
    }
}