package problems.leetcode.easy

class LeetCode_637 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private val mTotalLevelSum = HashMap<Int, Level>()

    class Level(var sum: Long, var totalNodes: Int)

    fun averageOfLevels(root: TreeNode?): DoubleArray {
        collectSum(root, 1)
        return DoubleArray(mTotalLevelSum.size) { index ->
            val level = mTotalLevelSum[index + 1]!!
            level.sum.toDouble() / level.totalNodes
        }
    }

    private fun collectSum(node: TreeNode?, currentLevel: Int) {
        if (node == null) return

        val levelAtContainer = mTotalLevelSum[currentLevel]
        if (levelAtContainer == null) {
            mTotalLevelSum[currentLevel] = Level(node.`val`.toLong(), 1)
        } else {
            levelAtContainer.sum += node.`val`
            levelAtContainer.totalNodes += 1
            mTotalLevelSum[currentLevel] = levelAtContainer
        }

        collectSum(node.left, currentLevel + 1)
        collectSum(node.right, currentLevel + 1)
    }
}