package problems.leetcode.easy

/**
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money
 * the i​​​​​​​​​​​th​​​​ customer has
 * in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.
 *
 * A customer's wealth is the amount of money they have in all their bank accounts.
 * The richest customer is the customer that has the maximum wealth.
 * */

class LeetCode_1672 {

    fun maximumWealth(accounts: Array<IntArray>): Int {
        val intArrSums = IntArray(accounts.size) { index -> accounts[index].sum() }
        return intArrSums.max()
    }

    private fun IntArray.max(): Int {
        var max = 0

        this.forEach { num ->
            if (num > max) {
                max = num
            }
        }

        return max
    }
}