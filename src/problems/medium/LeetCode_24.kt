package problems.medium

class LeetCode_24 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) return null
        if (head.next == null) return head

        var previous: ListNode? = null
        var currentNode = head
        val newHead = currentNode.next!!
        while (currentNode?.next != null) {
            val nextNodeFromCurrent = currentNode!!.next!!
            val nextNodeForSwap = nextNodeFromCurrent.next

            nextNodeFromCurrent.next = currentNode
            currentNode.next = nextNodeForSwap
            previous?.next = nextNodeFromCurrent

            previous = currentNode
            currentNode = nextNodeForSwap
        }


        return newHead
    }
}