package problems.medium


class LeetCode_1415 {

    fun getHappyString(n: Int, k: Int): String? {
        val arr = charArrayOf('a', 'b', 'c')
        var result = ""
        val permutation = mutableListOf<String>()
        generatePerm(arr, n, result, permutation)
        if (permutation.size >= k) result = permutation[k - 1]
        return result
    }

    private fun generatePerm(arr: CharArray, n: Int, res: String, permutation: MutableList<String>) {
        if (n == 0) {
            permutation.add(res)
            return
        }
        for (index in arr.indices) {
            if (res == "" || res[res.length - 1] != arr[index]) {
                val pre = res + arr[index]
                generatePerm(arr, n - 1, pre, permutation)
            }
        }
    }
}