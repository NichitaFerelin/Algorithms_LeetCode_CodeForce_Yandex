package problems.medium

class LeetCode_75 {

    fun sortColors(nums: IntArray): Unit {
        partition(nums)
    }

    private fun partition(data: IntArray) {
        if (data.size < 2) {
            return
        }
        val middle = data.size / 2
        var arrCursor = 0
        val leftArr = IntArray(middle) { data[arrCursor++] }
        val rightArr = IntArray(data.size - middle) { data[arrCursor++] }

        partition(leftArr)
        partition(rightArr)

        merge(data, leftArr, rightArr)
    }

    private fun merge(data: IntArray, leftArr: IntArray, rightArr: IntArray) {
        var mainArrCursor = 0
        var leftArrCursor = 0
        var rightArrCursor = 0
        while (leftArrCursor < leftArr.size && rightArrCursor < rightArr.size) {
            if (leftArr[leftArrCursor] <= rightArr[rightArrCursor]) {
                data[mainArrCursor++] = leftArr[leftArrCursor++]
            } else {
                data[mainArrCursor++] = rightArr[rightArrCursor++]
            }
        }
        while (leftArrCursor < leftArr.size) {
            data[mainArrCursor++] = leftArr[leftArrCursor++]
        }
        while (rightArrCursor < rightArr.size) {
            data[mainArrCursor++] = rightArr[rightArrCursor++]
        }
    }
}