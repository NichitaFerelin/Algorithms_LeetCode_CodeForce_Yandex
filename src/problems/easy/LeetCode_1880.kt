package problems.easy

class LeetCode_1880 {

    fun isSumEqual(firstWord: String, secondWord: String, targetWord: String): Boolean {
        return convertWordToNumber(firstWord) + convertWordToNumber(secondWord) == convertWordToNumber(targetWord)
    }

    private fun convertWordToNumber(word: String): Int {
        var resultNum = ""
        word.forEach { symbol -> resultNum += convertSymbolToInt(symbol) }
        var fromCursor = 0
        while (fromCursor < resultNum.length && resultNum[fromCursor] == '0') fromCursor++
        return if (fromCursor == resultNum.length) 0 else resultNum.substring(fromCursor).toInt()
    }

    private fun convertSymbolToInt(symbol: Char): Int {
        return kotlin.math.abs(107 - symbol.toInt() - 10)
    }
}