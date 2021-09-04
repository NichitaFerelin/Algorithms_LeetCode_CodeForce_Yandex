package problems.leetcode.easy

class LeetCode_485 {

    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var maxSequence = Int.MIN_VALUE
        var stepSequence = 0
        nums.forEach {
            if (it == 1) {
                stepSequence++
            } else {
                if (stepSequence > maxSequence) {
                    maxSequence = stepSequence
                }
                stepSequence = 0
            }
        }

        return if (stepSequence > maxSequence) stepSequence else maxSequence
    }
}