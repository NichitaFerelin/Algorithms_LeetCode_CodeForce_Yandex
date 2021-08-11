package problems.easy

class LeetCode_977 {

    fun sortedSquares(nums: IntArray): IntArray {
        val resultArr = IntArray(nums.size) { index -> nums[index] * nums[index] }
        return resultArr.sortedArray()
    }
}