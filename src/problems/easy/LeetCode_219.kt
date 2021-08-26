package problems.easy

class LeetCode_219 {

    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        for (outIndex in nums.indices) {
            for (inIndex in outIndex + 1 until nums.size) {
                if (kotlin.math.abs(outIndex - inIndex) <= k && nums[outIndex] == nums[inIndex]) {
                    return true
                }
            }
        }
        return false
    }
}