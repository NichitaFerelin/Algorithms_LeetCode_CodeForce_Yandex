package problems.leetcode.medium

class LeetCode_16 {

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var closestSum = Int.MAX_VALUE
        var minDifference = Int.MAX_VALUE

        for (outIndex in 0 until nums.size - 2) {
            val firstNumber = nums[outIndex]

            for (inIndex in outIndex + 1 until nums.size - 1) {
                val secondNumber = nums[inIndex]

                for (index in inIndex + 1 until nums.size) {
                    val thirdNumber = nums[index]
                    val sum = firstNumber + secondNumber + thirdNumber
                    val difference = kotlin.math.abs(sum - target)

                    if (difference < minDifference) {
                        minDifference = difference
                        closestSum = sum
                    }
                }
            }
        }

        return closestSum
    }
}