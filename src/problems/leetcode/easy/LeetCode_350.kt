package problems.leetcode.easy

class LeetCode_350 {

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val firstNums = HashMap<Int, Int>()
        nums1.forEach { firstNums[it] = firstNums.getOrDefault(it, 0) + 1 }

        val secondNums = HashMap<Int, Int>()
        nums2.forEach { secondNums[it] = secondNums.getOrDefault(it, 0) + 1 }

        val result = mutableListOf<Int>()
        firstNums.forEach { map ->
            val numAtSecondContainer = secondNums[map.key] ?: 0
            val numAtFirstContainer = map.value
            var addTimes = if (numAtSecondContainer > numAtFirstContainer) numAtFirstContainer else numAtSecondContainer
            while (addTimes > 0) {
                result.add(map.key)
                addTimes--
            }
        }

        return result.toIntArray()
    }
}