package problems.leetcode.medium

class LeetCode_1980 {

    fun findDifferentBinaryString(nums: Array<String>): String {
        val ans = StringBuilder()
        for (index in nums.indices) {
            val toAppend = if (nums[index][index] == '0') '1' else '0'
            ans.append(toAppend)
        }
        return ans.toString()
    }
}