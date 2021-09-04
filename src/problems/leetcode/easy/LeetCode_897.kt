package problems.leetcode.easy

import java.util.*

class LeetCode_897 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun increasingBST(root: TreeNode?): TreeNode? {
        val arrByTree = collectListByTree(root!!)
        val newRootNode = TreeNode(arrByTree[0])
        var currentNode = newRootNode
        for (index in 1 until arrByTree.size) {
            currentNode.right = TreeNode(arrByTree[index])
            currentNode = currentNode.right!!
        }
        return newRootNode
    }

    fun collectListByTree(root: TreeNode): List<Int> {
        if (root.right == null && root.left == null) {
            return listOf(root.`val`)
        }

        val path = Stack<TreeNode>()
        var currentNode: TreeNode = root
        while (currentNode.left != null) {
            path.push(currentNode)
            currentNode = currentNode.left!!
        }

        val explored = HashMap<TreeNode, Unit>()
        val result = mutableListOf<Int>()

        while (
            ((currentNode.left != null && explored[currentNode.left] == null)
                    || (currentNode.right != null && explored[currentNode.right] == null))
            || path.isNotEmpty()
        ) {
            when {
                currentNode.left != null && explored[currentNode.left] == null -> {
                    path.push(currentNode)
                    currentNode = currentNode.left!!
                }
                explored[currentNode] == null -> {
                    result.add(currentNode.`val`)
                    explored[currentNode] = Unit
                }
                currentNode.right != null && explored[currentNode.right] == null -> {
                    path.push(currentNode)
                    currentNode = currentNode.right!!
                }
                else -> currentNode = path.pop()
            }
        }

        if (explored[currentNode] == null) {
            result.add(currentNode.`val`)
        }

        return result
    }
}