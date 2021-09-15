package problems.leetcode.medium

class LeetCode_55 {

    fun canJump(nums: IntArray): Boolean {
        var jumpsRemains = 1
        var numsCursor = 0

        while (numsCursor < nums.size && jumpsRemains != 0) {
            jumpsRemains--

            if (nums[numsCursor] > jumpsRemains) {
                jumpsRemains = nums[numsCursor]
            }

            numsCursor++
        }

        return numsCursor == nums.size
    }
}