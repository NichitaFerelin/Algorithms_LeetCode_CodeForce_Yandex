package problems.leetcode.medium

class LeetCode_40 {

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        candidates.sort()
        backtracking(candidates, result, mutableListOf(), target, 0)
        return result
    }

    private fun backtracking(
        candidates: IntArray,
        results: MutableList<List<Int>>,
        currentSequence: MutableList<Int>,
        remain: Int,
        start: Int
    ) {
        when {
            remain < 0 -> return
            remain == 0 -> results.add(currentSequence.toList())
            else -> {
                for (index in start until candidates.size) {
                    if (index > start && candidates[index - 1] == candidates[index]) {
                        continue
                    }

                    currentSequence.add(candidates[index])
                    backtracking(candidates, results, currentSequence, remain - candidates[index], index + 1)
                    currentSequence.removeAt(currentSequence.lastIndex)
                }
            }
        }
    }
}