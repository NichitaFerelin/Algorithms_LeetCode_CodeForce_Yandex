package problems.leetcode.easy


class LeetCode_1002 {

    fun commonChars(words: Array<String>): List<String> {
        val result = mutableListOf<String>()
        var c = 'a'
        while (c <= 'z') {
            var minCount = Int.MAX_VALUE
            for (s in words) {
                var wordCount = 0
                for (cur_c in s.toCharArray()) if (cur_c == c) wordCount++
                minCount = Math.min(minCount, wordCount)
            }
            for (i in 0 until minCount) result.add("" + c)
            c++
        }
        return result
    }
}