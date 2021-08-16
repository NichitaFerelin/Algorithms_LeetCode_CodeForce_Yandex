package problems.easy

class LeetCode_1925 {

    fun countTriples(n: Int): Int {
        var count = 0
        for (a in 1..n) {
            for (b in 1..n) {
                val temp = a.coerceAtLeast(b)
                for (c in temp..n) {
                    if (a * a + b * b == c * c) count++
                }
            }
        }
        return count
    }
}