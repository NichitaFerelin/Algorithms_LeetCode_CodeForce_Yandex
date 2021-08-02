package problems.easy

/**
 * Given two arrays of integers nums and index. Your task is to create target array under the following rules:
 * Initially target array is empty.
 * From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 * Repeat the previous step until there are no elements to read in nums and index.
 * Return the target array.
 * It is guaranteed that the insertion operations will be valid.
 * */

class LeetCode_1389 {

    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        val result = mutableListOf<Int>()
        for (iterableIndex in nums.indices) {
            val targetIndex = index[iterableIndex]
            val number = nums[iterableIndex]
            result.add(targetIndex, number)
        }
        return result.toIntArray()
    }
}