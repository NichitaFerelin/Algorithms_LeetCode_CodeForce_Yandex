package problems.leetcode.easy

class LeetCode_824 {

    private val mViowels = HashMap<Char, Unit>(5).apply {
        put('a', Unit)
        put('e', Unit)
        put('i', Unit)
        put('o', Unit)
        put('u', Unit)
    }

    fun toGoatLatin(sentence: String): String {
        var resultStr = ""

        var sentenceCursor = 0
        var wordsCounter = 1
        var wordStart = sentenceCursor
        while (sentenceCursor < sentence.length) {
            if (sentence[sentenceCursor] == ' ') {
                val stepResultWord = sentence.substring(wordStart, sentenceCursor++)
                resultStr += "${changeStr(stepResultWord, wordsCounter++)} "
                wordStart = sentenceCursor
            } else sentenceCursor++
        }
        resultStr += changeStr(sentence.substring(wordStart, sentenceCursor), wordsCounter)
        return resultStr
    }

    private fun changeStr(string: String, wordCounter: Int): String {
        var newStr = string

        var postfix = ""
        var postrixCounter = wordCounter
        while (postrixCounter-- > 0) postfix += 'a'

        val firstSymbol = newStr[0]
        if (mViowels[firstSymbol.toLowerCase()] != null) {
            newStr += "ma"
        } else {
            newStr = newStr.removeRange(0, 1)
            newStr += "${firstSymbol}ma"
        }
        newStr += postfix
        return newStr
    }
}