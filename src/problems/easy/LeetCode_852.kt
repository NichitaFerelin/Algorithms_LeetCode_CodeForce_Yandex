package problems.easy

class LeetCode_852 {

    fun peakIndexInMountainArray(arr: IntArray): Int {
        var max = Int.MIN_VALUE
        var maxIndex = -1
        arr.forEachIndexed { index, num ->
            if (num > max) {
                max = num
                maxIndex = index
            }
        }
        return maxIndex
    }
}