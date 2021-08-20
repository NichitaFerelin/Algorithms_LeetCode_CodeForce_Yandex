package problems.easy

class LeetCode_448 {

    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val numsContainer = HashMap<Int, Unit>()
        nums.forEach { numsContainer[it] = Unit }
        val result = mutableListOf<Int>()
        for (number in 1..nums.size) {
            if (numsContainer[number] == null) result.add(number)
        }

        return result
    }
}