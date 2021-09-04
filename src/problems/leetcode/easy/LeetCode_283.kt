package problems.leetcode.easy

class LeetCode_283 {

    fun moveZeroes(nums: IntArray): Unit {
        var numsCursor = 0
        var nullCounter = 1
        while (numsCursor < nums.size - nullCounter) {
            if (nums[numsCursor] == 0) {
                var swapCursor = numsCursor
                while (swapCursor < nums.size - nullCounter) {
                    nums[swapCursor] = nums[swapCursor + 1]
                    swapCursor++
                }
                nums[nums.size - nullCounter] = 0
                nullCounter++
            } else numsCursor++
        }
    }
}