package problems.easy

class LeetCode_1089 {

    fun duplicateZeros(arr: IntArray): Unit {
        var arrCursor = 0
        while (arrCursor < arr.size) {
            if (arr[arrCursor] == 0) {
                for (index in arr.size - 1 downTo arrCursor + 1) {
                    arr[index] = arr[index - 1]
                }
                arrCursor += 2
            } else arrCursor++
        }
    }
}