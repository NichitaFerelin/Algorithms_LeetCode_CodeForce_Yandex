package problems.leetcode.medium

class LeetCode_1357 {

    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val pathsContainer = HashMap<Int, Int>(edges.size)
        edges.forEach { pathsContainer[it[1]] = it[0] }

        val result = mutableListOf<Int>()
        edges.forEach {
            if (pathsContainer[it[0]] == null && !result.contains(it[0])) result.add(it[0])
        }

        return result
    }
}