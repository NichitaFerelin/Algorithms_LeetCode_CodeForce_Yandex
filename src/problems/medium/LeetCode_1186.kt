package problems.medium

class LeetCode_1186 {

    fun maximumSum(arr: IntArray): Int {
        val maxWithOneDeletion = IntArray(arr.size)
        val maxWithNoDeletion = IntArray(arr.size)
        maxWithNoDeletion[0] = arr[0]

        var max = maxWithNoDeletion[0]

        for (index in 1 until arr.size) {
            maxWithOneDeletion[index] = maxOf(maxWithNoDeletion[index - 1], maxWithOneDeletion[index - 1] + arr[index])
            maxWithNoDeletion[index] = maxOf(maxWithNoDeletion[index - 1] + arr[index], arr[index])
            max = maxOf(maxWithOneDeletion[index], maxWithNoDeletion[index], max)
        }
        return max
    }
}