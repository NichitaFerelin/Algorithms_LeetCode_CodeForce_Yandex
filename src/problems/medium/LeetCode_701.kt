package problems.medium

class LeetCode_701 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return TreeNode(`val`)
        }

        var currentNode = root
        var inserted = false
        while (!inserted) {
            if (`val` < currentNode!!.`val`) {
                if (currentNode.left == null) {
                    inserted = true
                    currentNode.left = TreeNode(`val`)
                } else currentNode = currentNode.left
            } else {
                if (currentNode.right == null) {
                    inserted = true
                    currentNode.right = TreeNode(`val`)
                } else currentNode = currentNode.right
            }
        }

        return root
    }
}