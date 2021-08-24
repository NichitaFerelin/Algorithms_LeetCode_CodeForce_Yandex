package problems.easy

class LeetCode_14 {

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs[0].isEmpty()) return ""
        if (strs.size == 1) return strs[0]

        var strCursor = 0
        var currentChar = strs[0][strCursor]
        while (true) {
            for (index in 1 until strs.size) {
                val currentWord = strs[index]
                if (strCursor >= currentWord.length || currentWord[strCursor] != currentChar) {
                    return strs[0].substring(0, strCursor)
                }
            }
            strCursor++

            if (strCursor >= strs[0].length) {
                return strs[0].substring(0, strCursor)
            } else currentChar = strs[0][strCursor]
        }
    }
}