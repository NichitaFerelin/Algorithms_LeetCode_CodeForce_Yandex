package problems.medium


class LeetCode_22 {

    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        backtrack(result, "", 0, 0, n)
        return result
    }

    private fun backtrack(list: MutableList<String>, str: String, open: Int, close: Int, max: Int) {
        if (str.length == max * 2) {
            list.add(str)
            return
        }
        if (open < max) backtrack(list, "$str(", open + 1, close, max)
        if (close < open) backtrack(list, "$str)", open, close + 1, max)
    }
}