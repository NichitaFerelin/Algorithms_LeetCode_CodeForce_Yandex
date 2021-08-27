package problems.easy

class LeetCode_941 {

    fun validMountainArray(arr: IntArray): Boolean {
        if (arr.size < 3) return false

        var atLeastOneToBottom = false
        var atLeastOneToTop = false

        var arrCursor = 1
        while (arrCursor < arr.size && arr[arrCursor - 1] < arr[arrCursor]) {
            atLeastOneToTop = true
            arrCursor++
        }
        while (arrCursor < arr.size && arr[arrCursor - 1] > arr[arrCursor]) {
            atLeastOneToBottom = true
            arrCursor++
        }
        return arrCursor >= arr.size && atLeastOneToBottom && atLeastOneToTop
    }
}