package problems.leetcode.easy

class LeetCode_876 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun middleNode(head: ListNode?): ListNode? {
        val result = ArrayList<ListNode>()
        var currentNode = head
        while(currentNode != null) {
            result.add(currentNode)
            currentNode = currentNode.next
        }

        return result[result.size / 2]
    }
}