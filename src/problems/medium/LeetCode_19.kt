package problems.medium

class LeetCode_19 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var firstHead = head
        var secondHead = head

        var steps = n
        while (steps-- > 0) {
            secondHead = secondHead!!.next
        }

        if (secondHead == null) return head!!.next

        secondHead = secondHead.next

        while (secondHead != null) {
            firstHead = firstHead!!.next
            secondHead = secondHead.next
        }
        firstHead!!.next = firstHead.next!!.next

        return head
    }
}