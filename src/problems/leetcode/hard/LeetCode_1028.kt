package problems.leetcode.hard

import java.util.*

class LeetCode_1028 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun recoverFromPreorder(traversal: String): TreeNode? {
        var startCursor = 0
        while (startCursor < traversal.length && traversal[startCursor] != '-') {
            startCursor++
        }
        val rootNode = TreeNode(traversal.substring(0, startCursor).toString().toInt())

        val path = Stack<TreeNode>()

        var traversalCursor = startCursor
        var stepLevel = 1

        var currentNode = rootNode
        while (traversalCursor < traversal.length) {
            if (traversal[traversalCursor] == '-') {
                stepLevel++
            } else {
                while (path.size != stepLevel - 1 && path.isNotEmpty()) {
                    currentNode = path.pop()
                }

                val from = traversalCursor
                while (traversalCursor < traversal.length && traversal[traversalCursor] != '-') {
                    traversalCursor++
                }

                val newNode = TreeNode(traversal.substring(from, traversalCursor).toInt())
                if (currentNode.left == null) {
                    currentNode.left = newNode
                } else currentNode.right = newNode

                path.push(currentNode)
                path.push(newNode)

                currentNode = newNode
                stepLevel = 1
            }
            traversalCursor++
        }

        return rootNode
    }
}