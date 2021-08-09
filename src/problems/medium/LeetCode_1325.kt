package problems.medium

class LeetCode_1325 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        if (root == null) {
            return null
        }

        var newRoot = root
        while (newRoot!!.`val` == target) {
            when {
                newRoot.left == null && newRoot.right == null -> return null
                newRoot.left == null -> newRoot = newRoot.right
                newRoot.right == null -> newRoot = newRoot.left
                else -> {
                    newRoot = newRoot.left
                    newRoot!!.right = newRoot.right
                }
            }
        }

        newRoot.left = removeLeafNodes(newRoot.left, target)
        newRoot.right = removeLeafNodes(newRoot.right, target)

        return newRoot
    }
}