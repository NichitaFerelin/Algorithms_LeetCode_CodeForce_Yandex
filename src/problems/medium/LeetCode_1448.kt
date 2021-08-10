package problems.medium

class LeetCode_1448 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    var goodNodes = 0

    fun goodNodes(root: TreeNode?): Int {
        calculateGoodNodes(root!!)
        return goodNodes
    }

    fun calculateGoodNodes(root: TreeNode) {
        if (root.left == null && root.right == null) {
            goodNodes++
            return
        }

        val path = mutableListOf<TreeNode>()
        val exploredContainer = HashMap<TreeNode, Unit>()
        var currentNode = root

        while (path.isNotEmpty()
            || (root.left != null && exploredContainer[root.left] == null)
            || (root.right != null && exploredContainer[root.right] == null)
        ) {

            if (exploredContainer[currentNode] == null) {
                var isGood = true
                for (pathBefore in path) {
                    if (pathBefore.`val` > currentNode.`val`) {
                        isGood = false
                        break
                    }
                }

                if (isGood) goodNodes++

                exploredContainer[currentNode] = Unit
            }

            if (currentNode.left != null && exploredContainer[currentNode.left] == null) {
                path.add(currentNode)
                currentNode = currentNode.left!!
            } else if (currentNode.right != null && exploredContainer[currentNode.right] == null) {
                path.add(currentNode)
                currentNode = currentNode.right!!
            } else {
                currentNode = path[path.lastIndex]
                path.removeAt(path.lastIndex)
            }
        }
    }
}