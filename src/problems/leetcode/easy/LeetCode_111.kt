package problems.leetcode.easy

class LeetCode_111 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private var mMinDepth = Int.MAX_VALUE

    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        exploreDepth(root, 1)
        return mMinDepth
    }

    private fun exploreDepth(root: TreeNode, height: Int) {
        if (root.left == null && root.right == null) {
            if (height < mMinDepth) mMinDepth = height
            return
        }

        root.left?.let { exploreDepth(it, height + 1) }
        root.right?.let { exploreDepth(it, height + 1) }
    }
}