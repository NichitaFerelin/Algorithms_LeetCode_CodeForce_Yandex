package problems.medium

class LeetCode_1630 {

    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val results = mutableListOf<Boolean>()
        for (index in l.indices) {
            val leftBorder = l[index]
            val rightBorder = r[index]
            var arrCursor = leftBorder
            val newArr = IntArray(rightBorder - leftBorder + 1) { nums[arrCursor++] }
            results.add(canBeRearranged(newArr))
        }
        return results
    }

    fun canBeRearranged(nums: IntArray): Boolean {
        return when (nums.size) {
            1 -> false
            2 -> true
            else -> {
                nums.sort()
                val firstPairCompare = nums[0] - nums[1]
                for (index in 1 until nums.size - 1) {
                    if (nums[index] - nums[index + 1] != firstPairCompare) {
                        return false
                    }
                }
                true
            }
        }
    }
}