package problems.medium

class LeetCode_47 {

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        backtracking(nums.sortedArray(), BooleanArray(nums.size), result, mutableListOf())
        return result
    }

    private fun backtracking(
        nums: IntArray,
        used: BooleanArray,
        result: MutableList<List<Int>>,
        currentSequence: MutableList<Int>
    ) {
        if (currentSequence.size == nums.size) {
            result.add(currentSequence.toList())
            return
        }

        for (index in nums.indices) {
            if (used[index]) continue
            if (index > 0 && nums[index] == nums[index - 1] && !used[index - 1]) continue

            used[index] = true

            currentSequence.add(nums[index])
            backtracking(nums, used, result, currentSequence)
            used[index] = false
            currentSequence.removeAt(currentSequence.lastIndex)
        }
    }
}