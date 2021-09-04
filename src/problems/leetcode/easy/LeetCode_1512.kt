package problems.leetcode.easy

/**
 * Given an array of integers nums. A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 * Return the number of good pairs.
 * */

class LeetCode_1512 {

    fun numIdenticalPairs(nums: IntArray): Int {
        val container = hashMapOf<Int, MutableList<Int>>()
        var goodPairsCounter = 0

        nums.forEachIndexed { index, arrNumber ->
            val indexesHolder = container[arrNumber]
            if (indexesHolder == null) {
                container[arrNumber] = mutableListOf(index)
            } else {
                goodPairsCounter += indexesHolder.size
                indexesHolder.add(index)
            }
        }

        return goodPairsCounter
    }
}