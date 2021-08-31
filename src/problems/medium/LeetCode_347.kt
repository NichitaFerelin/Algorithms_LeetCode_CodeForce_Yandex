package problems.medium

class LeetCode_347 {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val numsFrequencyContainer = HashMap<Int, Int>()
        nums.forEach { numsFrequencyContainer[it] = numsFrequencyContainer.getOrDefault(it, 0) + 1 }
        val resultFrequency = numsFrequencyContainer.keys.sortedByDescending { numsFrequencyContainer[it]!! }

        val result = IntArray(k)
        var index = 0
        while (index < resultFrequency.size && index < k) {
            result[index] = resultFrequency[index]
            index++
        }
        return result
    }
}