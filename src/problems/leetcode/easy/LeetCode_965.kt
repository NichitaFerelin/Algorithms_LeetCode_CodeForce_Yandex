package problems.leetcode.easy

class LeetCode_965 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isUnivalTree(root: TreeNode?): Boolean {
        return if (root == null) {
            false
        } else {
            val targetValue = root.`val`
            isUnival(root, targetValue)
        }
    }

    private fun isUnival(root: TreeNode?, with: Int): Boolean {
        return when {
            root == null -> true
            root.`val` != with -> false
            else -> isUnival(root.left, with) && isUnival(root.right, with)
        }
    }
}