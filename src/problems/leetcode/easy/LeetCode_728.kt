package problems.leetcode.easy

class LeetCode_728 {

    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val result = mutableListOf<Int>()
        for (number in left..right) {
            var dividedNumber = number
            var ok = true
            while (dividedNumber != 0) {
                val lastNumber = dividedNumber % 10
                if (lastNumber == 0 || number % lastNumber != 0) {
                    ok = false
                    break
                }

                dividedNumber /= 10
            }

            if (ok) {
                result.add(number)
            }
        }

        return result
    }
}