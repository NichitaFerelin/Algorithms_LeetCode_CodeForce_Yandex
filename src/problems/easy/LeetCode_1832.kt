package problems.easy

/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 * Given a string sentence containing only lowercase English letters,
 * return true if sentence is a pangram, or false otherwise.
 * */

class LeetCode_1832 {

    fun checkIfPangram(sentence: String): Boolean {
        return sentence.toCharArray().toSet().size == 26
    }
}