package problems.leetcode.easy

class LeetCode_1598 {

    fun minOperations(logs: Array<String>): Int {
        var totalOperationsToBack = 0
        logs.forEach { log ->
            when (log) {
                "../" -> {
                    if (totalOperationsToBack != 0) totalOperationsToBack--
                }
                "./" -> Unit
                else -> totalOperationsToBack++
            }
        }

        return totalOperationsToBack
    }
}