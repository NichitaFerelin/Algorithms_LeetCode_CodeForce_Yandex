package problems.leetcode.easy

/**
 * Given a string s and an integer array indices of the same length.
 * The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 * Return the shuffled string.
 * */

class LeetCode_1528 {

    fun restoreString(s: String, indices: IntArray): String {
        val builder = StringBuilder(s)
        indices.forEachIndexed { index, position -> builder[position] = s[index] }
        return builder.toString()
    }
}