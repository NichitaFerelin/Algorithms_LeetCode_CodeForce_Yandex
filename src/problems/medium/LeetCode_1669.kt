package problems.medium

class LeetCode_1669 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        if (list1 == null || list2 == null) {
            return null
        }

        val targetStartMergeIndex = a
        val targetEndMergeIndex = b

        var listCursor = 0
        var currentNode: ListNode? = list1
        while (listCursor != targetStartMergeIndex - 1 && currentNode != null) {
            currentNode = currentNode.next
            listCursor++
        }

        if (listCursor != targetStartMergeIndex - 1) {
            return null
        }

        val mergeStart = currentNode

        while (listCursor != targetEndMergeIndex + 1 && currentNode != null) {
            currentNode = currentNode.next
            listCursor++
        }

        if (listCursor != targetEndMergeIndex + 1) {
            return null
        }

        val mergeEnd = currentNode

        mergeStart!!.next = list2

        currentNode = list2
        while (currentNode!!.next != null) {
            currentNode = currentNode.next
        }

        currentNode.next = mergeEnd

        return list1
    }

}