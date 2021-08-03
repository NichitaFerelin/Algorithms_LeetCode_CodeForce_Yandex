package problems.medium

/**
 * Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
 * */

class LeetCode_1008 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        val root = TreeNode(preorder[0])

        for (index in 1 until preorder.size) {
            var currentNode = root
            val numToInsert = preorder[index]

            var isInserted = false
            while (!isInserted) {
                if (numToInsert >= currentNode.`val`) {
                    if (currentNode.right == null) {
                        currentNode.right = TreeNode(numToInsert)
                        isInserted = true
                    } else currentNode = currentNode.right!!
                } else {
                    if (currentNode.left == null) {
                        currentNode.left = TreeNode(numToInsert)
                        isInserted = true
                    } else currentNode = currentNode.left!!
                }
            }
        }

        return root
    }
}