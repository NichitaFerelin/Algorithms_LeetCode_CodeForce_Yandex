package problems.medium

import algorithms.Naraiana

class LeetCode_46 {

    fun permute(nums: IntArray): List<List<Int>> {
        val permutation = Array(nums.size) { nums[it] }

        val result = mutableListOf<MutableList<Int>>()
        val firstPermutation = mutableListOf<Int>()
        firstPermutation.addAll(permutation)
        result.add(firstPermutation)

        var index = findMaxIndex(permutation) { first, second -> first < second }
        while (index != -1) {
            val element = permutation[index]
            val swapIndex = findIndexBiggerElement(permutation) { it > element }
            swap(permutation, index, swapIndex)
            reverse(permutation, index)
            val resPermutation = mutableListOf<Int>()
            resPermutation.addAll(permutation)
            result.add(resPermutation)
            index = findMaxIndex(permutation) { first, second -> first < second }
        }

        return result
    }

    private fun <T> findMaxIndex(permutation: Array<T>, compare: (T, T) -> Boolean): Int {
        for (index in permutation.size - 2 downTo 0) {
            if (compare(permutation[index], permutation[index + 1])) {
                return index
            }
        }
        return -1
    }

    private fun <T> findIndexBiggerElement(permutation: Array<T>, compare: (T) -> Boolean): Int {
        for (index in permutation.indices.reversed()) {
            if (compare(permutation[index])) {
                return index
            }
        }
        return -1
    }

    private fun <T> swap(source: Array<T>, first: Int, second: Int) {
        val temp = source[first]
        source[first] = source[second]
        source[second] = temp
    }

    private fun <T> reverse(source: Array<T>, index: Int) {
        val shift = index + 1
        for (i in 0 until (source.size - shift) / 2) {
            val temp = source[shift + i]
            source[shift + i] = source[source.size - i - 1]
            source[source.size - i - 1] = temp
        }
    }
}