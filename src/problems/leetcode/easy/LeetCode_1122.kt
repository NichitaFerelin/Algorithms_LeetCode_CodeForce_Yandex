package problems.leetcode.easy

class LeetCode_1122 {

    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val numsContainer = HashMap<Int, Int>(arr1.size)
        arr1.forEach { num ->
            numsContainer[num] = numsContainer.getOrDefault(num, 0) + 1
        }

        val result = mutableListOf<Int>()
        arr2.forEach { num ->
            var totalNumsAtFirstArr = numsContainer.getOrDefault(num, 0)
            while (totalNumsAtFirstArr > 0) {
                result.add(num)
                totalNumsAtFirstArr--
            }
            numsContainer.remove(num)
        }

        val notUsed = mutableListOf<Int>()
        numsContainer.forEach { map ->
            var totalTimes = map.value
            while(totalTimes > 0) {
                notUsed.add(map.key)
                totalTimes--
            }
        }

        notUsed.sort()
        result.addAll(notUsed)
        return result.toIntArray()
    }
}