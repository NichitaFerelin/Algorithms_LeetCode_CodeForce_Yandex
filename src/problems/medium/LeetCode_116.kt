package problems.medium

class LeetCode_116 {

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    fun connect(root: Node?): Node? {
        var startNode = root
        while (startNode != null) {

            var currentNode = startNode
            while (currentNode != null) {
                if (currentNode.left != null) {
                    currentNode.left!!.next = currentNode.right
                }

                if (currentNode.right != null && currentNode.next != null) {
                    currentNode.right!!.next = currentNode.next!!.left
                }
                currentNode = currentNode.next
            }
            startNode = startNode.left
        }
        return root
    }
}