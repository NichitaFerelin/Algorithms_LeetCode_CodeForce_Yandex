package problems.easy

class LeetCode_1137 {

    fun tribonacci(n: Int): Int {
        return when(n) {
            0 -> 0
            1 -> 1
            2 -> 2
            else -> {
                val trib = IntArray(n)
                trib[0] = 0
                trib[1] = 1
                trib[2] = 1
                for (index in 3 until trib.size) {
                    trib[index] = trib[index - 3] + trib[index - 2] + trib[index - 1]
                }

                trib[trib.lastIndex]
            }
        }
    }
}