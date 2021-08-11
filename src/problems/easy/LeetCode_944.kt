package problems.easy

class LeetCode_944 {

    fun minDeletionSize(A: Array<String>): Int {
        var count = 0
        for (i in 0 until A[0].length) {
            for (j in 1 until A.size) {
                if (A[j - 1][i] > A[j][i]) {
                    count++
                    break
                }
            }
        }

        return count
    }
}