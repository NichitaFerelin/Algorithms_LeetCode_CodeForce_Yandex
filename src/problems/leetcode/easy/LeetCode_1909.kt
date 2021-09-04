package problems.leetcode.easy

class LeetCode_1909 {

    fun canBeIncreasing(nums: IntArray): Boolean {
        var alreadyRemoved = false

        for (index in 1 until nums.size) {
            if (nums[index] <= nums[index - 1]) {
                if (alreadyRemoved) return false

                alreadyRemoved = true
                if (index > 1 && nums[index] <= nums[index - 2]) {
                    nums[index] = nums[index - 1]
                }
            }
        }
        return true
    }
}