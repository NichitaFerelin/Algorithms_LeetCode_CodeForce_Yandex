package problems.leetcode.medium

import kotlin.math.abs

class LeetCode_979 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private var steps = 0

    fun distributeCoins(root: TreeNode?): Int {
        postorder(root)
        return steps
    }

    private fun postorder(node: TreeNode?): Int {
        if (node == null) return 0

        var coin = postorder(node.left) + postorder(node.right)

        coin += if (node.`val` == 0) -1 else node.`val` - 1
        steps += abs(coin)
        return coin
    }
}