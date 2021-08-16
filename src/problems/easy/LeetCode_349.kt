package problems.easy

class LeetCode_349 {

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val firstNumsContainer = HashMap<Int, Unit>(nums1.size)
        nums1.forEach { firstNumsContainer[it] = Unit }

        val secondNumsContainer = HashMap<Int, Unit>(nums1.size)
        nums2.forEach { secondNumsContainer[it] = Unit }

        nums1.forEach { firstNumber ->
            val numAtSecondContainer = secondNumsContainer[firstNumber]
            if (numAtSecondContainer == null) {
                firstNumsContainer.remove(firstNumber)
            }
        }

        return firstNumsContainer.keys.toIntArray()
    }
}