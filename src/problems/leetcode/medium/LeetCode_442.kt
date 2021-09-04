package problems.leetcode.medium

class LeetCode_442 {

    fun findDuplicates(nums: IntArray): List<Int> {
        val duplicates = mutableListOf<Int>()
        val numsContainer = HashMap<Int, Unit>()
        nums.forEach {
            if (numsContainer[it] == null) {
                numsContainer[it] = Unit
            } else duplicates.add(it)
        }

        return duplicates
    }
}