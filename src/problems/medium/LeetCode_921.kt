package problems.medium

import java.util.*

class LeetCode_921 {

    fun minAddToMakeValid(s: String): Int {
        val parentheses = Stack<Char>()
        s.forEach { item ->
            if (item == '(') {
                parentheses.push(item)
            } else {
                if (parentheses.isNotEmpty() && parentheses.peek() == '(') {
                    parentheses.pop()
                } else parentheses.push(item)
            }
        }
        return parentheses.size
    }
}