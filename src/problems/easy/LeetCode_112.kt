package problems.easy

class LeetCode_112 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        return when {
            root == null -> false
            root.right == null && root.left == null -> root.`val` == targetSum
            else -> {
                val leftHasPath = hasPathSum(root.right, targetSum - root.`val`)
                val rightHasPath = hasPathSum(root.left, targetSum - root.`val`)
                return leftHasPath || rightHasPath
            }
        }
    }
}