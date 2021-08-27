package problems.easy

class LeetCode_268 {

    fun missingNumber(nums: IntArray): Int {
        var xor = 0
        var i = 0
        while (i < nums.size) {
            xor = xor xor i xor nums[i]
            i++
        }

        return xor xor i
    }
}