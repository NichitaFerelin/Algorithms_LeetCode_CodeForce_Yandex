package problems.leetcode.easy

class LeetCode_83 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        var currentNode = head
        while (currentNode != null) {
            val startNode = currentNode
            var nextNode = startNode.next
            while (nextNode != null && nextNode.`val` == startNode.`val`) {
                nextNode = nextNode.next
            }
            if (nextNode == null) {
                startNode.next = null
                return head
            } else startNode.next = nextNode

            currentNode = currentNode.next
        }

        return head
    }
}