package problems.leetcode.medium

class LeetCode_413 {

    fun numberOfArithmeticSlices(nums: IntArray): Int {
        var result = 0
        var stepSequence = 0
        for (index in 2 until nums.size) {
            if (nums[index] - nums[index - 1] == nums[index - 1] - nums[index - 2]) {
                stepSequence++
                result += stepSequence
            } else stepSequence = 0
        }
        return result
    }
}