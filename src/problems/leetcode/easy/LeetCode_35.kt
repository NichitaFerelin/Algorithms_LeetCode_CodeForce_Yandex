package problems.leetcode.easy

class LeetCode_35 {

    fun searchInsert(nums: IntArray, target: Int): Int {
        var leftBorder = 0
        var rightBorder = nums.lastIndex

        while (leftBorder <= rightBorder) {
            val middle = leftBorder + (rightBorder - leftBorder) / 2

            when {
                nums[middle] == target -> return middle
                nums[middle] < target -> leftBorder = middle + 1
                nums[middle] > target -> rightBorder = middle - 1
            }
        }

        return rightBorder + 1
    }
}