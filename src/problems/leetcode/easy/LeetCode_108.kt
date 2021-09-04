package problems.leetcode.easy

class LeetCode_108 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return buildTree(nums, 0, nums.size - 1)
    }

    private fun buildTree(nums: IntArray, leftBorder: Int, rightBorder: Int): TreeNode? {
        if (leftBorder > rightBorder) {
            return null
        }

        val middle = (leftBorder + rightBorder) / 2
        val root = TreeNode(nums[middle])

        root.left = buildTree(nums, leftBorder, middle - 1)
        root.right = buildTree(nums, middle + 1, rightBorder)

        return root
    }
}