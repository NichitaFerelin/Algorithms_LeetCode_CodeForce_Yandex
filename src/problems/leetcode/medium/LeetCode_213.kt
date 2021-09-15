package problems.leetcode.medium

class LeetCode_213 {

    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        if (nums.size == 2) return maxOf(nums[0], nums[1])

        val dpFirstVariant = IntArray(nums.size)
        val dpSecondVariant = IntArray(nums.size)

        dpFirstVariant[0] = nums[0]
        dpFirstVariant[1] = nums[0]

        dpSecondVariant[1] = nums[1]

        for (index in 2 until nums.size) {
            dpFirstVariant[index] = maxOf(dpFirstVariant[index - 1], dpFirstVariant[index - 2] + nums[index])
            dpSecondVariant[index] = maxOf(dpSecondVariant[index - 1], dpSecondVariant[index - 2] + nums[index])
        }
        return maxOf(dpFirstVariant[dpFirstVariant.lastIndex - 1], dpSecondVariant[dpSecondVariant.lastIndex])
    }
}