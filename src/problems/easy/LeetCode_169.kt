package problems.easy

class LeetCode_169 {

    fun majorityElement(nums: IntArray): Int {
        val numsContainer = HashMap<Int, Int>()
        nums.forEach { number ->
            numsContainer[number] = numsContainer.getOrDefault(number, 0) + 1
        }

        val times = nums.size / 2
        numsContainer.forEach {
            if (it.value > times) {
                return it.key
            }
        }

        return 0
    }
}