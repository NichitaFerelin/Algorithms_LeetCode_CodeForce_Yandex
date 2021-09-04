package problems.leetcode.easy

class LeetCode_1437 {

    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        var freeLength = k
        nums.forEach { number ->
            if (number == 1) {
                if(freeLength < k) return false
                freeLength = 0
            } else freeLength++
        }

        return true
    }
}