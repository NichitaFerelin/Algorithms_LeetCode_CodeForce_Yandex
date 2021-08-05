package problems.easy

class LeetCode_1295 {

    fun findNumbers(nums: IntArray): Int {
        return nums.count { it.toString().length % 2 == 0 }
    }
}