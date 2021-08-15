package problems.easy

class LeetCode_206 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        var nextNode = head.next!!.next
        var lastNode = head.next
        head.next!!.next = head
        head.next = null

        while (nextNode != null) {
            val temp = nextNode.next
            nextNode.next = lastNode
            lastNode = nextNode
            nextNode = temp
        }

        return lastNode
    }
}