package problems.medium

class LeetCode_1529 {

    fun minFlips(target: String): Int {
        val str = StringBuilder(target)
        var strCursor = str.lastIndex

        val initialStr = CharArray(str.length) { '0' }

        var totalFlips = 0

        while (strCursor >= 0) {
            if (initialStr[strCursor] != str[strCursor]) {
                var tempCursor = strCursor

                while (tempCursor > 0 && str[tempCursor - 1] == str[tempCursor]) {
                    tempCursor--
                }

                flip(initialStr, tempCursor)
                totalFlips++
            }

            strCursor--
        }

        strCursor = 0
        while (strCursor < str.length) {
            if (initialStr[strCursor] != str[strCursor]) {
                flip(initialStr, strCursor)
                totalFlips++
            }
            strCursor++
        }
        return totalFlips
    }

    private fun flip(str: CharArray, from: Int) {
        var tempCursor = from
        while (tempCursor < str.size) {
            val newSymbol = if (str[tempCursor] == '0') '1' else '0'
            str[tempCursor] = newSymbol
            tempCursor++
        }
    }
}