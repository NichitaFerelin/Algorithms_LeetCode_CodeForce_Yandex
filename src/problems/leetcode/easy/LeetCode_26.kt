package problems.leetcode.easy

class LeetCode_26 {

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var resultLength = nums.size

        var outIndex = 1
        while (outIndex < resultLength) {
            if (nums[outIndex - 1] == nums[outIndex]) {
                for (inIndex in outIndex until resultLength - 1) {
                    nums[inIndex] = nums[inIndex + 1]
                }
                resultLength--
            } else outIndex++
        }
        return resultLength
    }
}