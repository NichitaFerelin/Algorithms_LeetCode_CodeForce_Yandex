package problems.leetcode.easy

class LeetCode_88 {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var nums1Cursor = m - 1
        var nums2Cursor = n - 1
        var finalCursor = m + n - 1

        while (nums1Cursor >= 0 && nums2Cursor >= 0) {
            if (nums1[nums1Cursor] > nums2[nums2Cursor]) {
                nums1[finalCursor--] = nums1[nums1Cursor--]
            } else nums1[finalCursor--] = nums2[nums2Cursor--]
        }
        while (nums2Cursor >= 0) {
            nums1[finalCursor--] = nums2[nums2Cursor--]
        }
    }
}