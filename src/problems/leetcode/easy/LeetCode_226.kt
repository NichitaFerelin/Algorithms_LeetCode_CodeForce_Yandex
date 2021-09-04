package problems.leetcode.easy

class LeetCode_226 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun invertTree(root: TreeNode?): TreeNode? {
        if (root != null) {
            invert(root)
        }
        return root
    }

    private fun invert(node: TreeNode) {
        when {
            node.left == null && node.right == null -> return
            node.left != null && node.right != null -> {
                val temp = node.left
                node.left = node.right
                node.right = temp
                invert(node.left!!)
                invert(node.right!!)
            }
            node.left != null -> {
                node.right = node.left
                node.left = null
                invert(node.right!!)
            }
            node.right != null -> {
                node.left = node.right
                node.right = null
                invert(node.left!!)
            }
        }
    }
}