package problems.easy

class LeetCode_1385 {

    fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
        var counter = 0
        arr1.forEach { firstNum ->
            var arr2Cursor = 0
            while (arr2Cursor < arr2.size) {
                val secondNum = arr2[arr2Cursor++]
                if (kotlin.math.abs(firstNum - secondNum) <= d) {
                    return@forEach
                }
            }
            counter++
        }
        return counter
    }
}