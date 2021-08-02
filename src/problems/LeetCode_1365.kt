package problems

/**
 * Given the array nums, for each nums[i] find out how many numbers in the
 * array are smaller than it. That is, for each nums[i] you have to count the number of valid
 * j's such that j != i and nums[j] < nums[i].
 * Return the answer in an array.
 * */

class LeetCode_1365 {

    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val countArr = IntArray(101)
        val results = IntArray(nums.size)

        nums.forEachIndexed { index, number -> countArr[number]++ }
        for (index in 1..100) {
            countArr[index] += countArr[index - 1]
        }
        nums.forEachIndexed { index, number ->
            if (number == 0) {
                results[index] = 0
            } else results[index] = countArr[number - 1]
        }

        return results
    }
}