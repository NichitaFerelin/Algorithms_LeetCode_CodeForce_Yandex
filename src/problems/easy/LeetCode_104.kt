package problems.easy

class LeetCode_104 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    var maxDepth = 0

    fun maxDepth(root: TreeNode?): Int {
        root?.let { exploreDepth(it) }
        return maxDepth
    }

    private fun exploreDepth(node: TreeNode, currentDepth: Int = 1) {
        if (currentDepth > maxDepth) {
            maxDepth = currentDepth
        }

        if (node.left != null) {
            exploreDepth(node.left!!, currentDepth + 1)
        }

        if (node.right != null) {
            exploreDepth(node.right!!, currentDepth + 1)
        }
    }
}