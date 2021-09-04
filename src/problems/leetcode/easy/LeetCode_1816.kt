package problems.leetcode.easy

/**
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 * Each of the words consists of only uppercase and lowercase English letters (no punctuation).
 *
 * For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.
 * You are given a sentence s​​​​​​ and an integer
 * k​​​​​​. You want to truncate s​​​​​​
 * such that it contains only the first k​​​​​​ words.
 * Return s​​​​​​ after truncating it.
 * */

class LeetCode_1816 {

    fun truncateSentence(s: String, k: Int): String {
        val words = s.split(" ")
        var result = ""
        var cursor = 0
        while (cursor < k && cursor < words.size) {
            result += "${words[cursor++]} "
        }
        return result.substring(0, result.length - 1)
    }
}