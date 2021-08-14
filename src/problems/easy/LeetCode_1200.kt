package problems.easy

import java.util.*


class LeetCode_1200 {

    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        arr.sort()

        var min = Int.MAX_VALUE

        for (index in 0 until arr.size - 1) {
            val difference = arr[index + 1] - arr[index]

            if (difference < min) {
                min = difference
                result.clear()
                result.add(Arrays.asList(arr[index], arr[index + 1]))
            } else if (difference == min) {
                result.add(Arrays.asList(arr[index], arr[index + 1]))
            }
        }

        return result
    }
}