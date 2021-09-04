package problems.leetcode.easy

class LeetCode_589 {

    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    fun preorder(root: Node?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val resultList = mutableListOf<Int>()
        findChildren(root!!, resultList)
        return resultList
    }

    private fun findChildren(root: Node?, nodes: MutableList<Int>) {
        nodes.add(root!!.`val`)
        root.children.forEach { childrenNode -> findChildren(childrenNode, nodes) }
    }
}