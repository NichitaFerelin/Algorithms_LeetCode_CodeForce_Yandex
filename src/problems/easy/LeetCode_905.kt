package problems.easy

class LeetCode_905 {

    fun sortArrayByParity(nums: IntArray): IntArray {
        val result = mutableListOf<Int>()
        var middleCursor = 0
        nums.forEach { number ->
            if (number % 2 == 0) {
                result.add(middleCursor++, number)
            } else result.add(number)
        }
        return result.toIntArray()
    }
}