package problems.medium

class LeetCode_78 {

    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        backtracking(nums, result, mutableListOf(), 0)
        return result
    }

    private fun backtracking(
        nums: IntArray,
        result: MutableList<List<Int>>,
        currentSequence: MutableList<Int>,
        from: Int
    ) {
        result.add(currentSequence.toList())

        for (index in from until nums.size) {
            currentSequence.add(nums[index])
            backtracking(nums, result, currentSequence, index + 1)
            currentSequence.removeAt(currentSequence.lastIndex)
        }
    }
}