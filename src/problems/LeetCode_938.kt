package problems

import java.util.*

/**
 * Given the root node of a binary search tree and two integers
 * low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
 * */

class LeetCode_938 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null || (root.`val` in (high + 1) until low)) {
            return 0
        }

        val pathStack = Stack<TreeNode>()
        val explored = HashMap<TreeNode, Unit>()

        var amount = 0
        var currentNode = root
        while (currentNode != null) {

            if (currentNode.`val` in low..high && explored[currentNode] == null) {
                amount += currentNode.`val`
            }
            explored[currentNode] = Unit

            currentNode = when {
                currentNode.`val` <= low && currentNode.right != null && explored[currentNode.right] == null -> {
                    pathStack.push(currentNode)
                    currentNode.right
                }
                currentNode.`val` >= high && currentNode.left != null && explored[currentNode.left] == null -> {
                    pathStack.push(currentNode)
                    currentNode.left
                }
                currentNode.left != null && explored[currentNode.left] == null -> {
                    pathStack.push(currentNode)
                    currentNode.left
                }
                currentNode.right != null && explored[currentNode.right] == null -> {
                    pathStack.push(currentNode)
                    currentNode.right
                }
                else -> {
                    if (pathStack.isEmpty()) null else pathStack.pop()
                }
            }
        }

        return amount
    }
}