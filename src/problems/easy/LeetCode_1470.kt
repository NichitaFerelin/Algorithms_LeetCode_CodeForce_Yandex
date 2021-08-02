package problems.easy

/**
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 * */

class LeetCode_1470 {

    fun shuffle(nums: IntArray, n: Int): IntArray {
        var firstHalfCursor = 0
        var secondHalfCursor = n

        val result = IntArray(nums.size)

        var resultCursor = 0
        while (resultCursor < nums.size - 1) {
            result[resultCursor] = nums[firstHalfCursor++]
            result[resultCursor + 1] = nums[secondHalfCursor++]
            resultCursor += 2
        }

        return result
    }
}