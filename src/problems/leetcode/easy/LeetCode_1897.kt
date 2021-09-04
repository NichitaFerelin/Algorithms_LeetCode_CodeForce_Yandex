package problems.leetcode.easy

class LeetCode_1897 {

    fun makeEqual(words: Array<String>): Boolean {
        val chars = HashMap<Char, Int>()
        words.forEach { word ->
            word.forEach { symbol ->
                chars[symbol] = chars.getOrDefault(symbol, 0) + 1
            }
        }

        chars.forEach {
            if (it.value % words.size != 0) {
                return false
            }
        }

        return true
    }
}