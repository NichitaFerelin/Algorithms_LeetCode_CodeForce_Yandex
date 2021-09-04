package problems.leetcode.easy

/**
 * Given two string arrays word1 and word2, return true
 * if the two arrays represent the same string, and false otherwise.
 *
 * A string is represented by an array if the array elements concatenated in order forms the string.
 * */

class LeetCode_1662 {

    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        var firstWord = ""
        var secondWord = ""
        word1.forEach { firstWord += it }
        word2.forEach { secondWord += it }
        return firstWord == secondWord
    }
}