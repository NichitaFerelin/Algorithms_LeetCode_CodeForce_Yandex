package problems.easy

class LeetCode_1636 {

    fun frequencySort(nums: IntArray): IntArray {
        val numsFrequence = HashMap<Int, Int>()
        nums.forEach { numsFrequence[it] = numsFrequence.getOrDefault(it, 0) + 1 }

        val res = nums.sortedWith(object : Comparator<Int> {
            override fun compare(num1: Int, num2: Int): Int {
                val firstNumCounter = numsFrequence[num1]!!
                val secondNumCounter = numsFrequence[num2]!!

                return when {
                    num1 == num2 -> 0
                    firstNumCounter == secondNumCounter -> if (num1 > num2) -1 else 1
                    else -> if (firstNumCounter > secondNumCounter) 1 else -1
                }
            }
        })
        return res.toIntArray()
    }
}