package problems.leetcode.hard

class LeetCode_42 {

    fun trap(height: IntArray): Int {
        var leftBorder = 0
        var rightBorder = height.lastIndex

        var max = 0
        var leftmax = 0
        var rightmax = 0

        while (leftBorder <= rightBorder) {
            leftmax = leftmax.coerceAtLeast(height[leftBorder])
            rightmax = rightmax.coerceAtLeast(height[rightBorder])

            if (leftmax < rightmax) {
                max += leftmax - height[leftBorder]
                leftBorder++
            } else {
                max += rightmax - height[rightBorder]
                rightBorder--
            }
        }

        return max
    }
}