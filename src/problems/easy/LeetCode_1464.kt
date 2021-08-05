package problems.easy

class LeetCode_1464 {

    fun maxProduct(nums: IntArray): Int {
        var firstMax = Int.MIN_VALUE
        var secondMax = Int.MIN_VALUE
        nums.forEach { number ->
            if (number > secondMax) {
                if (number > firstMax) {
                    val previousFirstMax = firstMax
                    firstMax = number
                    secondMax = previousFirstMax
                } else secondMax = number
            }
        }

        return (firstMax - 1) * (secondMax - 1)
    }
}