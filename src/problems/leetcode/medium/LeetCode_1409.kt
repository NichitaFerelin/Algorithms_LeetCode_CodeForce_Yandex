package problems.leetcode.medium

/**
 * Given the array queries of positive integers between 1 and m,
 * you have to process all queries[i] (from i=0 to i=queries.length-1) according to the following rules:
 * In the beginning, you have the permutation P=[1,2,3,...,m].
 * For the current i, find the position of queries[i] in the permutation
 * P (indexing from 0) and then move this at the beginning of the permutation
 * P. Notice that the position of queries[i] in P is the result for queries[i].
 *
 * Return an array containing the result for the given queries.
 * */

class LeetCode_1409 {

    fun processQueries(queries: IntArray, m: Int): IntArray {
        val keysContainer = mutableListOf<Int>()
        for (index in 1..m) {
            keysContainer.add(index)
        }

        return IntArray(queries.size) { index ->
            val query = queries[index]
            val targetIndex = keysContainer.indexOf(query)
            val item = keysContainer[targetIndex]
            keysContainer.removeAt(targetIndex)
            keysContainer.add(0, item)
            targetIndex
        }
    }
}