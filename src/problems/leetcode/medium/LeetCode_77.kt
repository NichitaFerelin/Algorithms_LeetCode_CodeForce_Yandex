package problems.leetcode.medium


class LeetCode_77 {

    fun combine(n: Int, k: Int): List<List<Int>> {
        val combs = mutableListOf<List<Int>>()
        combine(combs, ArrayList(), 1, n, k)
        return combs
    }

    private fun combine(combs: MutableList<List<Int>>, comb: MutableList<Int>, start: Int, n: Int, k: Int) {
        if (k == 0) {
            combs.add(ArrayList(comb))
            return
        }
        for (i in start..n) {
            comb.add(i)
            combine(combs, comb, i + 1, n, k - 1)
            comb.removeAt(comb.size - 1)
        }
    }
}