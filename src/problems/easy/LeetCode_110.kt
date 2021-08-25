package problems.easy

class LeetCode_110 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isBalanced(root: TreeNode?): Boolean {
        return if (root == null) true else exploreNode(root) != -1
    }

    private fun exploreNode(node: TreeNode?): Int {
        if (node == null) return 0

        val leftHeight = exploreNode(node.left)
        if (leftHeight == -1) return -1

        val rightHeight = exploreNode(node.right)
        if (rightHeight == -1) return -1

        return if (leftHeight - rightHeight < -1 || leftHeight - rightHeight > 1) {
            -1
        } else leftHeight.coerceAtLeast(rightHeight) + 1
    }
}