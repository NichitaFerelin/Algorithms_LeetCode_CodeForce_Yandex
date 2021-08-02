package problems.easy

/**
 * We are given a list nums of integers representing a list compressed with run-length encoding.
 * Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).
 * For each such pair, there are freq elements with value val concatenated in a sublist.
 * Concatenate all the sublists from left to right to generate the decompressed list
 * Return the decompressed list.
 * */

class LeetCode_1313 {

    fun decompressRLElist(nums: IntArray): IntArray {
        val results = mutableListOf<Int>()

        var numsCursor = 0
        while (numsCursor < nums.size - 1) {
            val freq = nums[numsCursor]
            val value = nums[numsCursor + 1]

            var addCounter = freq
            while (addCounter-- > 0) {
                results.add(value)
            }
            numsCursor += 2
        }

        return results.toIntArray()
    }
}