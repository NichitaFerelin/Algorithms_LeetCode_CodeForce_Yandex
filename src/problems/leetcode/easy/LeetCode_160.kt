package problems.leetcode.easy

class LeetCode_160 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var aLength = 0
        var currentNode = headA
        while (currentNode != null) {
            aLength++
            currentNode = currentNode.next
        }

        var bLength = 0
        currentNode = headB
        while (currentNode != null) {
            bLength++
            currentNode = currentNode.next
        }

        var leftNode: ListNode? = headA
        var rightNode: ListNode? = headB

        if (aLength < bLength) {
            val difference = bLength - aLength
            var steps = difference
            while (steps > 0) {
                rightNode = rightNode?.next
                steps--
            }
            if (rightNode == null) return null
        } else if (bLength < aLength) {
            val difference = aLength - bLength
            var steps = difference
            while (steps > 0) {
                leftNode = leftNode?.next
                steps--
            }
            if (leftNode == null) return null
        }

        while (leftNode != null && rightNode != null) {
            if (leftNode == rightNode) {
                return leftNode
            }
            leftNode = leftNode.next
            rightNode = rightNode.next
        }

        return null
    }
}