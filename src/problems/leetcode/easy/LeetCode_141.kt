package problems.leetcode.easy

class LeetCode_141 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun hasCycle(head: ListNode?): Boolean {
        val nodesContainer = HashMap<ListNode, Unit>()

        var currentNode = head
        while (currentNode != null) {
            val nodeAtContainer = nodesContainer[currentNode]
            if (nodeAtContainer == null) {
                nodesContainer[currentNode] = Unit
            } else return true

            currentNode = currentNode.next
        }

        return false
    }
}