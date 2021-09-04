package problems.leetcode.medium

class LeetCode_189 {

    fun rotate(nums: IntArray, k: Int): Unit {
        if (nums.size == 1) return

        var times = k
        while (times > 0) {
            val lastNum = nums[nums.lastIndex]
            for (index in nums.lastIndex downTo 1) {
                nums[index] = nums[index - 1]
            }
            nums[0] = lastNum

            times--
        }
    }
}