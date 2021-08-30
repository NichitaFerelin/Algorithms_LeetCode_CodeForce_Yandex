package problems.medium

import java.util.*

class LeetCode_17 {

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val queue: Queue<String> = LinkedList()
        queue.add("")

        val available = listOf("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

        digits.forEachIndexed { index, symbol ->
            val digit = symbol.toString().toInt()
            val toAdd = available[digit].toCharArray()
            while (queue.peek().length == index) {
                val temp = queue.remove()
                toAdd.forEach { queue.add(temp + it) }
            }
        }
        return queue.toList()
    }
}