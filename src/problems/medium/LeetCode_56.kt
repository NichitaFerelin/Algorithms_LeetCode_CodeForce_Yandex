package problems.medium

class LeetCode_56 {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size <= 1) return intervals
        intervals.sortBy { it[0] }

        val result = mutableListOf<IntArray>()
        var newInterval = intervals[0]
        result.add(newInterval)

        intervals.forEach {
            val from = it[0]
            val to = it[1]

            if (from <= newInterval[1]) {
                newInterval[1] = maxOf(newInterval[1], to)
            } else {
                newInterval = it
                result.add(newInterval)
            }
        }
        return result.toTypedArray()
    }
}