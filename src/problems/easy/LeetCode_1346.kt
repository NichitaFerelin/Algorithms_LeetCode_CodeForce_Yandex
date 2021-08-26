package problems.easy

class LeetCode_1346 {

    fun checkIfExist(arr: IntArray): Boolean {
        val numsContainer = HashMap<Int, Int>()
        arr.forEach { numsContainer[it] = numsContainer.getOrDefault(it, 0) + 1 }

        for (outIndex in arr.indices) {
            if (numsContainer[arr[outIndex] * 2] != null
                && (arr[outIndex] * 2 != arr[outIndex] || numsContainer[arr[outIndex] * 2]!! > 1)
            ) {
                return true
            }
        }
        return false
    }
}