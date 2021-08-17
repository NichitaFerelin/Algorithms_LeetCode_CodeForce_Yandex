package problems.easy

class LeetCode_1848 {

    fun getMinDistance(nums: IntArray, target: Int, start: Int): Int {
        var numsCursor = 0
        var minimized = Int.MAX_VALUE

        while (numsCursor < nums.size) {
            if (nums[numsCursor] == target) {
                val difference = kotlin.math.abs(numsCursor - start)
                if (difference < minimized) minimized = difference
            }
            numsCursor++
        }
        return minimized
    }
}