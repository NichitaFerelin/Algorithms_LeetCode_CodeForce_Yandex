package problems.leetcode.easy

class LeetCode_896 {

    fun isMonotonic(nums: IntArray): Boolean {
        if (nums.size == 1) return true

        var isDecreasing: Boolean? = null

        for (index in 1 until nums.size) {

            if (nums[index - 1] < nums[index]) {
                if (isDecreasing == null) {
                    isDecreasing = false
                } else if (isDecreasing) {
                    return false
                }
            } else if (nums[index - 1] > nums[index]) {
                if (isDecreasing == null) {
                    isDecreasing = true
                } else if (!isDecreasing) {
                    return false
                }
            }
        }

        return true
    }
}