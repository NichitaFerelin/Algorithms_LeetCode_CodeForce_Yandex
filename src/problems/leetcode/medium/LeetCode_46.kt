package problems.leetcode.medium


class LeetCode_46 {

    fun letterCasePermutation(S: String): List<String> {
        val res: MutableList<String> = ArrayList()
        val a = S.toLowerCase().toCharArray()
        helper(a, 0, res)
        return res
    }

    private fun helper(a: CharArray, pos: Int, res: MutableList<String>) {
        if (pos == a.size) {
            res.add(String(a))
            return
        }
        helper(a, pos + 1, res)
        if (Character.isLetter(a[pos])) {
            a[pos] = Character.toUpperCase(a[pos])
            helper(a, pos + 1, res)
            a[pos] = Character.toLowerCase(a[pos])
        }
    }
}