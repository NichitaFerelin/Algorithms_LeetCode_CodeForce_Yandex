package problems

/**
 * The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).
 * For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
 * Given an integer array nums, choose four distinct indices w, x, y, and z such
 * that the product difference between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.
 *
 * Return the maximum such product difference.
 * */

class LeetCode_1913 {

    fun maxProductDifference(nums: IntArray): Int {
        var firstMax = Int.MIN_VALUE
        var secondMax = Int.MIN_VALUE
        var firstMin = Int.MAX_VALUE
        var secondMin = Int.MAX_VALUE

        for (number in nums) {
            if (number > secondMax) {
                if (number > firstMax) {
                    val previousFirstMax = firstMax
                    firstMax = number
                    secondMax = previousFirstMax
                } else {
                    secondMax = number
                }
            }

            if (number < secondMin) {
                if (number < firstMin) {
                    val previousFirstMin = firstMin
                    firstMin = number
                    secondMin = previousFirstMin
                } else {
                    secondMin = number
                }
            }
        }

        return (firstMax * secondMax) - (firstMin * secondMin)
    }
}