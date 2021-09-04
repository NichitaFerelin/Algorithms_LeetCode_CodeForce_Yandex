package problems.leetcode.medium

class LeetCode_216 {

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        backtracking(result, mutableListOf(), 0, n, k, 1)
        return result
    }

    private fun backtracking(
        result: MutableList<List<Int>>,
        currentSequence: MutableList<Int>,
        currentSum: Int,
        targetResult: Int,
        targetCombinations: Int,
        from: Int
    ) {
        if (currentSequence.size == targetCombinations && currentSum == targetResult) {
            result.add(currentSequence.toList())
            return
        }

        for (number in from..9) {
            currentSequence.add(number)
            backtracking(
                result,
                currentSequence,
                currentSum + number,
                targetResult,
                targetCombinations,
                number + 1
            )
            currentSequence.removeAt(currentSequence.lastIndex)
        }
    }
}