package problems.leetcode.easy

class LeetCode_404 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        return if (root != null) collectSum(root, false) else 0
    }

    private fun collectSum(node: TreeNode, isLeft: Boolean): Int {
        var sum = 0
        if (isLeft && node.left == null && node.right == null) {
            sum += node.`val`
        }

        if (node.left != null) sum += collectSum(node.left!!, true)
        if (node.right != null) sum += collectSum(node.right!!, false)
        return sum
    }
}