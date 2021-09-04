package problems.leetcode.easy

class LeetCode_872 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val firstRoot = mutableListOf<Int>()
        val secondRoot = mutableListOf<Int>()

        collectData(root1!!, firstRoot)
        collectData(root2!!, secondRoot)

        if (firstRoot.size != secondRoot.size) {
            return false
        }

        firstRoot.forEachIndexed { index, num ->
            if (num != secondRoot[index]) return false
        }

        return true
    }

    private fun collectData(root: TreeNode, to: MutableList<Int>) {
        if (root.left == null && root.right == null) {
            to.add(root.`val`)
            return
        }

        if (root.left != null) collectData(root.left!!, to)
        if (root.right != null) collectData(root.right!!, to)
    }
}