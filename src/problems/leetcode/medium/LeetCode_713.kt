package problems.leetcode.medium

class LeetCode_713 {

    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if (k == 0) return 0

        var counter = 0
        var stepProduct = 1

        var i = 0
        var numsCursor = 0
        while (numsCursor < nums.size) {
            stepProduct *= nums[numsCursor]
            while (i <= numsCursor && stepProduct >= k) {
                stepProduct /= nums[i++]
            }
            counter += numsCursor - i + 1
            numsCursor++
        }
        return counter
    }

    private fun backtracking(
        nums: IntArray,
        result: MutableList<List<Int>>,
        currentSequence: MutableList<Int>,
        currentProduct: Int,
        targetProduct: Int,
        from: Int
    ) {
        if (currentProduct >= targetProduct) {
            return
        } else if (currentSequence.isNotEmpty()) result.add(currentSequence.toList())

        for (index in from until nums.size) {
            currentSequence.add(nums[index])
            backtracking(nums, result, currentSequence, currentProduct * nums[index], targetProduct, index + 1)

            if (currentSequence.size > 1) {
                currentSequence.removeAt(currentSequence.lastIndex)
                break
            } else if (currentSequence.size == 1) {
                currentSequence.removeAt(currentSequence.lastIndex)
            }
        }
    }
}