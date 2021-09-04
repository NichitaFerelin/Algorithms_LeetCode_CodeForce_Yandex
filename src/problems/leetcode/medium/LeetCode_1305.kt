package problems.leetcode.medium

import java.util.*

class LeetCode_1305 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val itemsByFirstNode = if (root1 == null) emptyList() else collectListByTree(root1)
        val itemsBySecondNode = if (root2 == null) emptyList() else collectListByTree(root2)
        val result = mutableListOf<Int>()

        var firstNodeCursor = 0
        var secondNodeCursor = 0
        while (firstNodeCursor < itemsByFirstNode.size && secondNodeCursor < itemsBySecondNode.size) {
            if (itemsByFirstNode[firstNodeCursor] > itemsBySecondNode[secondNodeCursor]) {
                result.add(itemsBySecondNode[secondNodeCursor++])
            } else result.add(itemsByFirstNode[firstNodeCursor++])
        }

        while (firstNodeCursor < itemsByFirstNode.size) {
            result.add(itemsByFirstNode[firstNodeCursor++])
        }

        while (secondNodeCursor < itemsBySecondNode.size) {
            result.add(itemsBySecondNode[secondNodeCursor++])
        }

        return result.toList()
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