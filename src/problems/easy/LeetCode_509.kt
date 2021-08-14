package problems.easy

class LeetCode_509 {

    fun fib(n: Int): Int {
        return when (n) {
            0 -> 0
            1 -> 1
            else -> fib(n - 1) + fib(n - 2)
        }
    }
}