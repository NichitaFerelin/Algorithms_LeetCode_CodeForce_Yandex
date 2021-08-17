package problems.easy

class LeetCode_21 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) {
            return l2
        } else if (l2 == null) {
            return l1
        }

        var currentLeftNode = l1
        var currentRightNode = l2

        val newNodeVal = if (currentLeftNode.`val` < currentRightNode.`val`) {
            val value = currentLeftNode.`val`
            currentLeftNode = currentLeftNode.next
            value
        } else {
            val value = currentRightNode.`val`
            currentRightNode = currentRightNode.next
            value
        }

        val resultNode = ListNode(newNodeVal)
        var currentResultNode = resultNode
        while (currentLeftNode != null && currentRightNode != null) {
            if (currentLeftNode.`val` < currentRightNode.`val`) {
                currentResultNode.next = currentLeftNode
                currentLeftNode = currentLeftNode.next
            } else {
                currentResultNode.next = currentRightNode
                currentRightNode = currentRightNode.next
            }

            currentResultNode = currentResultNode.next!!
        }

        while (currentLeftNode != null) {
            currentResultNode.next = currentLeftNode
            currentLeftNode = currentLeftNode.next
            currentResultNode = currentResultNode.next!!
        }

        while (currentRightNode != null) {
            currentResultNode.next = currentRightNode
            currentRightNode = currentRightNode.next
            currentResultNode = currentResultNode.next!!
        }

        return resultNode
    }
}