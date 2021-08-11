package problems.easy

class LeetCode_922 {

    fun sortArrayByParityII(nums: IntArray): IntArray {
        val evens = mutableListOf<Int>()
        val odds = mutableListOf<Int>()
        nums.forEach { if (it % 2 == 0) evens.add(it) else odds.add(it) }

        var evensCursor = 0
        var oddsCursor = 0

        var numsCursor = 0
        while (evensCursor < evens.size && oddsCursor < odds.size) {
            nums[numsCursor] = if (numsCursor % 2 == 0) evens[evensCursor++] else odds[oddsCursor++]
            numsCursor++
        }

        while (evensCursor < evens.size) {
            nums[numsCursor++] = evens[evensCursor++]
        }

        while (oddsCursor < odds.size) {
            nums[numsCursor++] = odds[oddsCursor++]
        }

        return nums
    }
}