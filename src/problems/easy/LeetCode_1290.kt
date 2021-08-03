package problems.easy

/**
 * Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 * */

class LeetCode_1290 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun getDecimalValue(head: ListNode?): Int {
        val binaryArr = IntArray(30)

        var arrCursor = 0
        var currentNode = head
        while (currentNode != null) {
            binaryArr[arrCursor++] = currentNode.`val`
            currentNode = currentNode.next
        }

        var resultNumber = 0
        val rightBorder = arrCursor
        var currentDegree = rightBorder - 1

        arrCursor = 0
        while (arrCursor < rightBorder) {
            resultNumber += binaryArr[arrCursor] * (2).pow(currentDegree)
            currentDegree--
            arrCursor++
        }

        return resultNumber
    }

    fun Int.pow(pow: Int): Int {
        if (pow == 0) {
            return 1
        }

        var result = this
        var stepPow = pow

        while (stepPow > 1) {
            result *= this
            stepPow--
        }

        return result
    }
}