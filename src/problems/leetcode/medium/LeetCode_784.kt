package problems.leetcode.medium

class LeetCode_784 {

    fun letterCasePermutation(s: String): List<String> {
        val result = mutableListOf<String>()

        return result
    }

    private fun backtrack(result: MutableList<String>, initialStr: String, currentSequence: CharArray) {
        if (currentSequence.size == initialStr.length) {
            result.add(StringBuilder(currentSequence.toString()).toString())
            return
        }


    }
}