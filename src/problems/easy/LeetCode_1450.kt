package problems.easy

class LeetCode_1450 {

    fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
        var studentsCounter = 0
        for (index in startTime.indices) {
            if (queryTime >= startTime[index] && queryTime <= endTime[index]) {
                studentsCounter++
            }
        }
        return studentsCounter
    }
}