package problems.medium

class LeetCode_45 {

    fun jump(nums: IntArray): Int {
        if (nums.size == 1) return 0

        val dp = IntArray(nums.size - 1)
        for (index in nums.lastIndex - 1 downTo 0) {
            if (nums[index] == 0) continue

            val jumpLength = nums[index]
            if (jumpLength >= nums.lastIndex - index) {
                dp[index] = 1
            } else {
                var minIndex = -1
                var minValueToEnd = -1

                var times = jumpLength
                var tempCursor = index + 1
                while (tempCursor < dp.size && times > 0) {
                    if ((minIndex == -1 || dp[tempCursor] < minValueToEnd) && dp[tempCursor] != 0) {
                        minIndex = tempCursor
                        minValueToEnd = dp[tempCursor]
                    }
                    times--
                    tempCursor++
                }

                dp[index] = minValueToEnd + 1
            }
        }

        return dp[0]
    }
}