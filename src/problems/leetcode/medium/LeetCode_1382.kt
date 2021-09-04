package problems.leetcode.medium

import java.util.*

class LeetCode_1382 {


    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun balanceBST(root: TreeNode?): TreeNode? {
        val arrByTree = collectArrFromTree(root!!)
        return createTreeByArr(arrByTree)
    }

    fun createTreeByArr(arrByTree: IntArray): TreeNode {
        if (arrByTree.size <= 3) {
            return when (arrByTree.size) {
                1 -> TreeNode(arrByTree[0])
                2 -> {
                    if (arrByTree[0] > arrByTree[1]) {
                        TreeNode(arrByTree[0]).apply {
                            left = TreeNode(arrByTree[1])
                        }
                    } else {
                        TreeNode(arrByTree[1]).apply {
                            left = TreeNode(arrByTree[0])
                        }
                    }
                }
                else -> {
                    val root = TreeNode(arrByTree[1])
                    if (arrByTree[0] > arrByTree[2]) {
                        root.left = TreeNode(arrByTree[2])
                        root.right = TreeNode(arrByTree[0])
                    } else {
                        root.left = TreeNode(arrByTree[0])
                        root.right = TreeNode(arrByTree[2])
                    }
                    root
                }
            }
        }

        val middleRoot = arrByTree.size / 2
        val rootNode = TreeNode(arrByTree[middleRoot])

        var arrCursor = 0
        val leftArr = IntArray(middleRoot) { arrByTree[arrCursor++] }
        arrCursor++
        val rightArr = IntArray(arrByTree.size - middleRoot - 1) { arrByTree[arrCursor++] }

        rootNode.left = createTreeByArr(leftArr)
        rootNode.right = createTreeByArr(rightArr)
        return rootNode
    }

    private fun collectArrFromTree(root: TreeNode): IntArray {
        if (root.right == null && root.left == null) {
            return intArrayOf(root.`val`)
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

        return result.toIntArray()
    }
}