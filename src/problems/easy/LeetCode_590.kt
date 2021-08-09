package problems.easy

class LeetCode_590 {

    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    val result = mutableListOf<Int>()

    fun postorder(root: Node?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        root.children.forEach { childrenNode -> postorder(childrenNode) }
        result.add(root.`val`)

        return result
    }
}