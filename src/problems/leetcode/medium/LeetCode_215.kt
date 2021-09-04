package problems.leetcode.medium

class LeetCode_215 {

    fun findKthLargest(nums: IntArray, k: Int): Int {
        sort(nums)
        return nums[k - 1]
    }

    private fun sort(data: IntArray, left: Int = 0, right: Int = data.size - 1) {
        if (left < right) {
            val pivotIndex = partition(data, left, right)
            sort(data, left, pivotIndex - 1)
            sort(data, pivotIndex + 1, right)
        }
    }

    private fun partition(data: IntArray, left: Int, right: Int): Int {
        val pivot = data[right]
        var partitionIndex = left - 1

        for (index in left until right) {
            if (data[index] > pivot) {
                swap(data, index, ++partitionIndex)
            }
        }

        swap(data, partitionIndex + 1, right)
        return partitionIndex + 1
    }

    private fun swap(data: IntArray, first: Int, second: Int) {
        val temp = data[first]
        data[first] = data[second]
        data[second] = temp
    }
}