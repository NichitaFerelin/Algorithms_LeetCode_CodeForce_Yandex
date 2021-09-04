package problems.leetcode.easy

class LeetCode_1952 {
    fun isThree(n: Int): Boolean {
        var total = 0
        var temp = n
        while (temp > 0) {
            if (n % temp == 0) total++
            temp--
        }

        return total == 3
    }
}