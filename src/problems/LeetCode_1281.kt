package problems

/**
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 * */

class LeetCode_1281 {

    fun subtractProductAndSum(n: Int): Int {
        var product = 1
        var amount = 0
        n.toString().forEach { numSymbol ->
            val number = numSymbol.toString().toInt()
            amount += number
            product *= number
        }
        return product - amount
    }
}