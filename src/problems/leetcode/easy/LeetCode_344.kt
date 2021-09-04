package problems.leetcode.easy

import java.util.*

class LeetCode_344 {

    fun reverseString(s: CharArray): Unit {
        val symbols = Stack<Char>()
        s.forEach { symbols.push(it) }
        s.forEachIndexed { index, _ -> s[index] = symbols.pop() }
    }
}