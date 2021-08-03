package problems.easy

/**
 * Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.
 *
 * A subarray is a contiguous subsequence of the array.
 * Return the sum of all odd-length subarrays of arr.
 * */

class LeetCode_1588 {

    fun sumOddLengthSubarrays(arr: IntArray): Int {
        var total = 0
        var divisionCounter = 1

        var arrCursor = 0
        while (divisionCounter <= arr.size) {
            val rightBorderExcluding = arrCursor + divisionCounter
            if (rightBorderExcluding > arr.size) {
                divisionCounter += 2
                arrCursor = 0
            } else {
                var cursor = arrCursor
                while (cursor < rightBorderExcluding) {
                    total += arr[cursor++]
                }
                arrCursor++
            }
        }

        return total
    }
}