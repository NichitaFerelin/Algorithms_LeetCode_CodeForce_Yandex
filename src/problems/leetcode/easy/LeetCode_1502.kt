package problems.leetcode.easy

class LeetCode_1502 {

    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        arr.sort()
        if (arr.size < 3) {
            return true
        }

        val difference = kotlin.math.abs(arr[0] - arr[1])
        for (index in 1 until arr.size - 1) {
            if (kotlin.math.abs(arr[index] - arr[index + 1]) != difference) {
                return false
            }
        }

        return true
    }
}