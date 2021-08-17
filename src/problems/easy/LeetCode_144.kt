package problems.easy

import java.util.*

class LeetCode_144 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val explored = HashMap<TreeNode, Unit>()
        val path = Stack<TreeNode>()
        val result = mutableListOf<Int>()

        var currentNode: TreeNode? = root

        while (
            root.left != null && explored[root.left] == null
            || root.right != null && explored[root.right] == null
            || path.isNotEmpty()
        ) {
            if (explored[currentNode!!] == null) {
                result.add(currentNode.`val`)
            }
            explored[currentNode] = Unit

            when {
                (currentNode.left == null || explored[currentNode.left] != null)
                        && (currentNode.right == null || explored[currentNode.right] != null) -> {
                    currentNode = path.pop()
                }
                currentNode.left != null && explored[currentNode.left] == null -> {
                    path.push(currentNode)
                    currentNode = currentNode.left
                }
                currentNode.right != null && explored[currentNode.right] == null -> {
                    path.push(currentNode)
                    currentNode = currentNode.right
                }
            }
        }

        if (result.isEmpty()) {
            result.add(root.`val`)
        }

        return result
    }
}