package problems.leetcode.easy

import java.util.*

class LeetCode_653 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun findTarget(root: TreeNode?, target: Int): Boolean {
        if (root == null || (root.left == null && root.right == null)) return false

        val firstPointExplored = HashMap<TreeNode, Unit>()
        val firstPointsPath = Stack<TreeNode>()

        val secondPointExplored = HashMap<TreeNode, Unit>()
        val secondPointPath = Stack<TreeNode>()

        var firstPoint = root

        var secondPoint = if (firstPoint.left == null) firstPoint.right else firstPoint.left
        secondPointPath.push(firstPoint)

        while (
            firstPointsPath.isNotEmpty() ||
            (root.left != null && firstPointExplored[root.left] == null ||
                    (root.right != null && firstPointExplored[root.right] == null))
        ) {
            while (
                secondPointPath.isNotEmpty() ||
                (root.left != null && secondPointExplored[root.left] == null) ||
                (root.right != null && secondPointExplored[root.right] == null)
            ) {
                if (secondPointExplored[secondPoint] == null) {
                    if (secondPoint != firstPoint && firstPoint!!.`val` + secondPoint!!.`val` == target) {
                        return true
                    }
                    secondPointExplored[secondPoint!!] = Unit
                }

                when {
                    (secondPoint!!.left == null || secondPointExplored[secondPoint.left] != null) &&
                            (secondPoint.right == null || secondPointExplored[secondPoint.right] != null) -> {
                        secondPoint = secondPointPath.pop()
                    }
                    secondPoint.left != null && secondPointExplored[secondPoint.left] == null -> {
                        secondPointPath.push(secondPoint)
                        secondPoint = secondPoint.left
                    }
                    secondPoint.right != null && secondPointExplored[secondPoint.right] == null -> {
                        secondPointPath.push(secondPoint)
                        secondPoint = secondPoint.right
                    }
                }
            }

            secondPointExplored.clear()
            firstPointExplored[firstPoint!!] = Unit

            when {
                (firstPoint.left == null || firstPointExplored[firstPoint.left] != null) &&
                        (firstPoint.right == null || firstPointExplored[firstPoint.right] != null) -> {
                    firstPoint = firstPointsPath.pop()
                }
                firstPoint.left != null && firstPointExplored[firstPoint.left] == null -> {
                    firstPointsPath.push(firstPoint)
                    firstPoint = firstPoint.left
                }
                firstPoint.right != null && firstPointExplored[firstPoint.right] == null -> {
                    firstPointsPath.push(firstPoint)
                    firstPoint = firstPoint.right
                }
            }
        }

        return false
    }
}