package problems.medium

class LeetCode_814 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun pruneTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        root.left = pruneTree(root.left)
        root.right = pruneTree(root.right)

        if (root.left == null && root.right == null && root.`val` == 0) {
            return null
        }
        return root
    }
}