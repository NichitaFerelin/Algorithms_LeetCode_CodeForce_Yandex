package problems.easy

import java.util.*

class LeetCode_20 {

    fun isValid(s: String): Boolean {
        val parentheses = Stack<Char>()
        s.forEach { symbol ->
            if (symbol == '(' || symbol == '[' || symbol == '{') {
                parentheses.push(symbol)
            } else {
                if (parentheses.isEmpty()) {
                    return false
                }

                val last = parentheses.pop()
                when {
                    last == '(' && symbol == ')' -> Unit
                    last == '[' && symbol == ']' -> Unit
                    last == '{' && symbol == '}' -> Unit
                    else -> return false
                }
            }
        }

        return parentheses.isEmpty()
    }
}