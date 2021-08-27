package problems.easy

class LeetCode_205 {

    fun isIsomorphic(s: String, t: String): Boolean {
        return transformStr(s) == transformStr(t)
    }

    private fun transformStr(str: String): String {
        val charsContainer = HashMap<Char, Int>()
        val result = StringBuilder(str)
        var currentKey = 'a'
        str.forEachIndexed { index, symbol ->
            val symbolPreviousPosition = charsContainer[symbol]
            if (symbolPreviousPosition == null) {
                result[index] = currentKey
                charsContainer[symbol] = index
                currentKey++
            } else {
                val previousKey = result[symbolPreviousPosition]
                result[index] = previousKey
            }
        }

        return result.toString()
    }
}