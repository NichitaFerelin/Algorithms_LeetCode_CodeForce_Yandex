package problems.medium

class LeetCode_1936 {

    fun addRungs(rungs: IntArray, dist: Int): Int {
        var previous = 0
        var totalStairsToAdd = 0
        rungs.forEach {
            totalStairsToAdd += (it - previous - 1) / dist
            previous = it
        }
        return totalStairsToAdd
    }
}