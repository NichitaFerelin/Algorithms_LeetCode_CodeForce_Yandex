package problems.leetcode.easy

class LeetCode_1022 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private val mTotalNumbers = mutableListOf<String>()

    fun sumRootToLeaf(root: TreeNode?): Int {
        collectNumbers(root!!, "")
        var sum = 0
        mTotalNumbers.forEach { strNumber ->
            strNumber.forEachIndexed { index, symbol ->
                val num = symbol.toString().toInt()
                sum += num * ((2).pow(strNumber.length - index - 1))
            }
        }

        return sum
    }

    fun collectNumbers(root: TreeNode, path: String) {
        val currentPath = "$path${root.`val`}"

        if (root.left == null && root.right == null) {
            mTotalNumbers.add(currentPath)
            return
        }

        if (root.left != null) {
            collectNumbers(root.left!!, currentPath)
        }

        if (root.right != null) {
            collectNumbers(root.right!!, currentPath)
        }
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