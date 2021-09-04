package problems.leetcode.easy

class LeetCode_217 {

    fun containsDuplicate(nums: IntArray): Boolean {
        return nums.toSet().size != nums.size
    }
}