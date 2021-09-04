package problems.leetcode.easy

class LeetCode_617 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if (root1 == null && root2 == null) {
            return null
        }

        val leftNode = root1?.`val` ?: 0
        val rightNode = root2?.`val` ?: 0
        val resultNode = TreeNode(leftNode + rightNode)

        resultNode.left = mergeTrees(root1?.left, root2?.left)
        resultNode.right = mergeTrees(root1?.right, root2?.right)

        return resultNode
    }
}