package problems.easy

class LeetCode_1332 {

    fun removePalindromeSub(s: String): Int {
        return if (s.isEmpty()) {
            0
        } else {
            if (s == s.reversed()) 1 else 2
        }
    }
}