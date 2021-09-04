package problems.leetcode.easy

/**
 * Given an integer num, return the number of steps to reduce it to zero.
 * In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 * */

class LeetCode_1342 {

    fun numberOfSteps(num: Int): Int {
        var stepsCounter = 0
        var currentNum = num
        while (currentNum > 0) {
            currentNum -= if (currentNum % 2 == 0) {
                currentNum / 2
            } else 1
            stepsCounter++
        }
        return stepsCounter
    }
}