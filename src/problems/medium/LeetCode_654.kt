package problems.medium

/**
 * You are given an integer array nums with no duplicates.
 * A maximum binary tree can be built recursively from nums using the following algorithm:
 *
 * Create a root node whose value is the maximum value in nums.
 * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 * Return the maximum binary tree built from nums.
 * */

class LeetCode_654 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        return constructTree(nums, 0, nums.lastIndex)
    }

    fun constructTree(nums: IntArray, leftBorder: Int, rightBorder: Int): TreeNode? {
        if (leftBorder > rightBorder) {
            return null
        }

        if (leftBorder == rightBorder) {
            return TreeNode(nums[leftBorder])
        }

        var max = Int.MIN_VALUE
        var maxIndex = -1
        var leftCursor = leftBorder
        while (leftCursor <= rightBorder) {
            if (nums[leftCursor] > max) {
                max = nums[leftCursor]
                maxIndex = leftCursor
            }
            leftCursor++
        }

        val currentRoot = TreeNode(max)
        currentRoot.left = constructTree(nums, leftBorder, maxIndex - 1)
        currentRoot.right = constructTree(nums, maxIndex + 1, rightBorder)

        return currentRoot
    }

    fun IntArray.max(): IntArray {
        var max = Int.MIN_VALUE
        var maxIndex = -1

        this.forEachIndexed { index, num ->
            if (num > max) {
                max = num
                maxIndex = index
            }
        }

        return intArrayOf(max, maxIndex)
    }
}