package problems.easy

class LeetCode_13 {
    fun romanToInt(s: String): Int {
        val nums = IntArray(s.length) { index ->
            when (s[index]) {
                'I' -> 1
                'V' -> 5
                'X' -> 10
                'L' -> 50
                'C' -> 100
                'D' -> 500
                'M' -> 1000
                else -> 0
            }
        }

        var result = 0
        for (index in 0 until nums.size - 1) {
            if (nums[index] > nums[index + 1]) {
                result += nums[index]
            } else result -= nums[index]
        }
        result += nums[nums.lastIndex]
        return result
    }
}