package problems.leetcode.easy

import java.util.*

class LeetCode_1417 {

    fun reformat(s: String): String {
        val letters = Stack<Char>()
        val numbers = Stack<Char>()
        for (index in s.length - 1 downTo 0) {
            if (s[index].isLetter()) {
                letters.push(s[index])
            } else numbers.push(s[index])
        }

        if (numbers.isEmpty() && letters.size == 1) {
            return "${letters.pop()}"
        } else if(letters.isEmpty() && numbers.size == 1) {
            return "${numbers.pop()}"
        }

        var result = ""
        while (numbers.isNotEmpty() && letters.isNotEmpty()) {
            val num = numbers.pop()
            val letter = letters.pop()

            result += if (numbers.size > letters.size) {
                "$num$letter"
            } else "$letter$num"
        }

        if (numbers.isNotEmpty() && result.isNotEmpty() && result[result.lastIndex].isLetter()) {
            result += numbers.pop()
        } else if (letters.isNotEmpty() && result.isNotEmpty() && result[result.lastIndex].isDigit()) {
            result += letters.pop()
        }

        return result
    }
}