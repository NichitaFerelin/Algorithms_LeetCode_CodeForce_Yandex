package problems.easy

class LeetCode_700 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        var currentNode = root
        while (currentNode != null) {
            if (currentNode.`val` == `val`) {
                return currentNode
            }

            currentNode = if (currentNode.`val` > `val`) currentNode.left else currentNode.right
        }

        return null
    }
}