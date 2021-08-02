package problems.easy

/**
 * Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i]
 * and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).Specifically, ans is the concatenation of two nums arrays.
 * Return the array ans.
 * */

class LeetCode_1929 {

    fun getConcatenation(nums: IntArray): IntArray {
        return IntArray(nums.size * 2).apply {
            nums.forEachIndexed { index, num ->
                this[index] = num
                this[index + nums.size] = num
            }
        }
    }
}