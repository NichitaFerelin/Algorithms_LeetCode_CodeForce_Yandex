package problems.medium

class LeetCode_912 {

    fun sortArray(nums: IntArray): IntArray {
        mergeSort(nums)
        return nums
    }

    private fun mergeSort(data: IntArray) {
        if (data.size < 2) {
            return
        }
        val middle = data.size / 2
        var arrCursor = 0
        val leftArr = IntArray(middle) { data[arrCursor++] }
        val rightArr = IntArray(data.size - middle) { data[arrCursor++] }

        mergeSort(leftArr)
        mergeSort(rightArr)

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