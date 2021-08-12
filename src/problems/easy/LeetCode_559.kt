package problems.easy

class LeetCode_559 {

    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    var maxDepth = 1

    fun maxDepth(root: Node?): Int {
        return if (root != null) {
            findDepth(root, 1)
            maxDepth
        } else 0
    }

    private fun findDepth(node: Node, currentLevel: Int) {
        if (currentLevel > maxDepth) {
            maxDepth = currentLevel
        }

        node.children.forEach {
            if (it != null) findDepth(it, currentLevel + 1)
        }
    }
}