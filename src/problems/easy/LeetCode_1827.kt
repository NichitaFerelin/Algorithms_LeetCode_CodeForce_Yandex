package problems.easy

class LeetCode_1827 {

    fun minOperations(nums: IntArray): Int {
        if (nums.size == 1) {
            return 0
        }

        var increases = 0
        for (index in 1 until nums.size) {
            if (nums[index] == nums[index - 1]) {
                nums[index]++
                increases++
            } else if (nums[index] < nums[index - 1]) {
                val toIncrease = nums[index - 1] - nums[index] + 1
                nums[index] += toIncrease
                increases += toIncrease
            }
        }

        return increases
    }
}