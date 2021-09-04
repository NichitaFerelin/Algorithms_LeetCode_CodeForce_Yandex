package problems.leetcode.medium

class LeetCode_797 {

    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val resultPaths = mutableListOf<MutableList<Int>>()
        val stepPath = mutableListOf(0)

        findPaths(graph, 0, resultPaths, stepPath)
        return resultPaths
    }

    private fun findPaths(
        graph: Array<IntArray>,
        currentNode: Int,
        resultPaths: MutableList<MutableList<Int>>,
        stepPath: MutableList<Int>
    ) {
        if (currentNode == graph.lastIndex) {
            resultPaths.add(ArrayList(stepPath))
            return
        }

        graph[currentNode].forEach { nextNode ->
            stepPath.add(nextNode)
            findPaths(graph, nextNode, resultPaths, stepPath)
            stepPath.removeLast()
        }
    }
}