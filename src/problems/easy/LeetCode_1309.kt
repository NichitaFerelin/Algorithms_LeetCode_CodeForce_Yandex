package problems.easy

class LeetCode_1309 {

    fun freqAlphabets(s: String): String {
        var resultStr = ""
        var strCursor = 0
        while (strCursor < s.length) {
            val currentSym = s[strCursor]

            if (strCursor < s.length - 2 && s[strCursor + 2] == '#') {
                resultStr += getByKey("$currentSym${s[strCursor + 1]}")
                strCursor += 3
            } else {
                resultStr += getByKey("$currentSym")
                strCursor++
            }
        }

        return resultStr
    }

    fun getByKey(key: String): Char {
        return (96 + key.toInt()).toChar()
    }
}