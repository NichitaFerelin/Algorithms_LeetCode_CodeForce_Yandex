package problems.leetcode.easy

class LeetCode_167 {

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        for (outIndex in numbers.indices) {
            for (inIndex in outIndex + 1 until numbers.size) {
                if (numbers[outIndex] + numbers[inIndex] == target) {
                    return intArrayOf(outIndex + 1, inIndex + 1)
                }
            }
        }

        return intArrayOf()
    }
}