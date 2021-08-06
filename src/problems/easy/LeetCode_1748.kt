package problems.easy

class LeetCode_1748 {

    fun sumOfUnique(nums: IntArray): Int {
        val pastContainerNums = HashMap<Int, Boolean>(nums.size)
        var sum = 0
        nums.forEach { number ->
            val alreadyWas = pastContainerNums[number]
            if (alreadyWas == null) {
                sum += number
                pastContainerNums[number] = false
            } else if (!alreadyWas) {
                sum -= number
                pastContainerNums[number] = true
            }
        }

        return sum
    }
}