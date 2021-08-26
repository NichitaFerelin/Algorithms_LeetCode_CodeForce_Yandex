package problems.easy

class LeetCode_203 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var newHead = head
        var previous: ListNode? = null
        var currentNode = head

        while (currentNode != null) {
            if (currentNode.`val` == `val`) {
                if (previous == null) {
                    newHead = currentNode.next
                } else previous.next = currentNode.next

                currentNode = currentNode.next
            } else {
                previous = currentNode
                currentNode = currentNode.next
            }
        }
        return newHead
    }
}