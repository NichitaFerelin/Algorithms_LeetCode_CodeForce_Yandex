package problems.leetcode.easy

class LeetCode_1800 {

    fun maxAscendingSum(nums: IntArray): Int {
        val sums = mutableListOf<Int>()

        var lastNum = Int.MIN_VALUE
        var currentSum = 0
        nums.forEach { number ->
            if (number > lastNum) {
                currentSum += number
            } else {
                sums.add(currentSum)
                currentSum = number
            }
            lastNum = number
        }
        sums.add(currentSum)

        var max = Int.MIN_VALUE
        sums.forEach { if (it > max) max = it }
        return max
    }
}