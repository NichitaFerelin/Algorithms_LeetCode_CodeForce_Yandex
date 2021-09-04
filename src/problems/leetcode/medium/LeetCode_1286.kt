package problems.leetcode.medium

import java.util.*


class LeetCode_1286(characters: String, combinationLength: Int) {

    private val pq = PriorityQueue<String>()

    init {
        generateSub(characters, combinationLength, 0, StringBuilder())
    }

    private fun generateSub(str: String, length: Int, start: Int, result: StringBuilder) {
        if (length == 0) {
            pq.add(result.toString())
            return
        }
        for (index in start..str.length - length) {
            result.append(str[index])
            generateSub(str, length - 1, index + 1, result)
            result.deleteCharAt(result.length - 1)
        }
    }

    fun next(): String {
        return pq.poll()
    }

    fun hasNext(): Boolean {
        return pq.isNotEmpty()
    }
}