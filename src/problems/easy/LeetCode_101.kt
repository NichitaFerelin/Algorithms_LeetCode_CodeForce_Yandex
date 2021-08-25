package problems.easy

class LeetCode_101 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isSymmetric(root: TreeNode?): Boolean {
        return isSameTree(root!!.left, root.right)
    }

    private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return when {
            p == null || q == null -> p == q
            p.`val` != q.`val` -> false
            else -> isSameTree(p.left, q.right) && isSameTree(p.right, q.left)
        }
    }
}