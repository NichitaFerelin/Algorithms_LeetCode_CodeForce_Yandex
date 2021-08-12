package problems.medium

class LeetCode_1953 {

    fun numberOfWeeks(milestones: IntArray): Long {
        var max = -1
        var sum: Long = 0
        var cursor = 0
        while (cursor < milestones.size) {
            max = max.coerceAtLeast(milestones[cursor])
            sum += milestones[cursor]
            cursor++
        }

        val result = sum - max
        return if (max - result > 1) sum - (max - result - 1) else sum
    }
}