package problems.leetcode.medium

class LeetCode_1387 {

    fun getKth(intervalStart: Int, intervalEnd: Int, returnTargetPosition: Int): Int {
        var currentInterval = intervalStart
        val resultInterval = IntArray(intervalEnd - intervalStart + 1) { currentInterval++ }

        val powerArr = IntArray(resultInterval.size) { index ->
            var stepsToBecomePowerNum = 0
            var tempNum = resultInterval[index]
            while (tempNum != 1) {
                tempNum = if (tempNum % 2 == 0) tempNum / 2 else 3 * tempNum + 1
                stepsToBecomePowerNum++
            }
            stepsToBecomePowerNum
        }

        val powerMap = HashMap<Int, Int>(powerArr.size)
        resultInterval.forEachIndexed { index, powerOwner ->
            val power = powerArr[index]
            powerMap[powerOwner] = power
        }

        val sortedByPower = resultInterval.sortedBy { powerMap[it]!! }
        return sortedByPower[returnTargetPosition - 1]
    }
}