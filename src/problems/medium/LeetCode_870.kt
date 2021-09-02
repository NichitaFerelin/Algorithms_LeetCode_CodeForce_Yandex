package problems.medium

class LeetCode_870 {

    fun advantageCount(nums1: IntArray, nums2: IntArray): IntArray {
        val availableNums = nums1.sorted().toMutableList()
        val resultPermutation = IntArray(nums1.size)
        var resultCursor = 0

        nums2.forEach { secondNum ->
            val position = kotlin.math.abs(search(availableNums, secondNum))
            val comparedNum = if (position >= availableNums.size) {
                availableNums.removeAt(0)
            } else availableNums.removeAt(position)
            resultPermutation[resultCursor++] = comparedNum
        }
        return resultPermutation
    }

    private fun search(nums: MutableList<Int>, target: Int): Int {
        var leftBorder = 0
        var rightBorder = nums.lastIndex

        while (leftBorder <= rightBorder) {
            val middle = leftBorder + (rightBorder - leftBorder) / 2
            when {
                target == nums[middle] -> return middle
                target > nums[middle] -> leftBorder = middle + 1
                target < nums[middle] -> rightBorder = middle - 1
            }
        }

        return -leftBorder
    }
}

