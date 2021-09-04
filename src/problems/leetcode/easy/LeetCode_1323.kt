package problems.leetcode.easy

class LeetCode_1323 {

    fun maximum69Number(num: Int): Int {
        return num.toString().replaceFirst("6", "9").toInt()
    }
}