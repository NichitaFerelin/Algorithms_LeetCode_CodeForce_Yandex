package problems.leetcode.medium

class LeetCode_1961 {

    fun isPrefixString(s: String, words: Array<String>): Boolean {
        var currentStr = ""
        var wordsCursor = 0
        while (wordsCursor < words.size) {
            currentStr += words[wordsCursor++]
            if (s == currentStr) {
                return true
            }

            if (s.length < currentStr.length) {
                break
            }
        }

        return false
    }
}