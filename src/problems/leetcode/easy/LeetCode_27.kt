package problems.leetcode.easy

class LeetCode_27 {

    fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.isEmpty()) return 0

        var resultLength = nums.size

        var outIndex = 0
        while (outIndex < resultLength) {
            if (nums[outIndex] == `val`) {
                for (inIndex in outIndex until resultLength - 1) {
                    nums[inIndex] = nums[inIndex + 1]
                }
                resultLength--
            } else outIndex++
        }
        return resultLength
    }
}