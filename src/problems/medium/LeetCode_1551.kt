package problems.medium

import java.util.*

/**
 * You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).
 * In one operation, you can select two indices x and y where 0 <= x,
 * y < n and subtract 1 from arr[x] and add 1 to arr[y] (i.e. perform
 * arr[x] -=1 and arr[y] += 1). The goal is to make all the elements
 * of the array equal. It is guaranteed that all the elements of the
 * array can be made equal using some operations.
 *
 * Given an integer n, the length of the array.
 * Return the minimum number of operations needed to make all the elements of arr equal.
 * */

class LeetCode_1551 {

    fun minOperations(n: Int): Int {
        var totalSteps = 0

        val free = Stack<Int>()
        val leftOfTarget = Stack<Int>()
        val rightOfTarget = Stack<Int>()

        val workArr = IntArray(n) { index -> (2 * index) + 1 }
        val targetValue = workArr.sum() / workArr.size
        workArr.forEachIndexed { index, num ->
            when {
                num == targetValue -> free.push(index)
                num > targetValue -> rightOfTarget.push(index)
                else -> leftOfTarget.push(index)
            }
        }

        while (leftOfTarget.isNotEmpty() || rightOfTarget.isNotEmpty()) {
            if (leftOfTarget.isNotEmpty()) {
                val valueIndexToIncrease = leftOfTarget.pop()
                val valueToIncrease = workArr[valueIndexToIncrease]

                if (rightOfTarget.isNotEmpty()) {
                    val valueIndexToDecrease = rightOfTarget.pop()
                    val valueToDecrease = workArr[valueIndexToDecrease]

                    val differenceBtwTargetIncrease = targetValue - valueToIncrease
                    val differenceBtwTargetDecrease = valueToDecrease - targetValue

                    if (differenceBtwTargetIncrease < differenceBtwTargetDecrease) {
                        workArr[valueIndexToIncrease] = targetValue
                        workArr[valueIndexToDecrease] = valueToDecrease - differenceBtwTargetIncrease

                        totalSteps += differenceBtwTargetIncrease

                        free.push(valueIndexToIncrease)
                        rightOfTarget.push(valueIndexToDecrease)
                    } else {
                        workArr[valueIndexToDecrease] = targetValue
                        workArr[valueIndexToIncrease] = valueToIncrease + differenceBtwTargetDecrease
                        free.push(valueIndexToDecrease)

                        totalSteps += differenceBtwTargetDecrease

                        if (workArr[valueIndexToIncrease] == targetValue) {
                            free.push(valueIndexToIncrease)
                        } else leftOfTarget.push(valueIndexToIncrease)
                    }
                } else {
                    val valueIndexToDecrease = free.pop()
                    workArr[valueIndexToDecrease] = targetValue - 1
                    leftOfTarget.push(valueIndexToDecrease)

                    workArr[valueIndexToIncrease] = valueToIncrease + 1
                    if (workArr[valueIndexToIncrease] != targetValue) {
                        leftOfTarget.push(valueIndexToIncrease)
                    } else free.push(valueIndexToIncrease)

                    totalSteps += 1
                }
            } else {
                val valueIndexToDecrease = rightOfTarget.pop()
                val valueToDecrease = workArr[valueIndexToDecrease]

                if (leftOfTarget.isNotEmpty()) {
                    val valueIndexToIncrease = rightOfTarget.pop()
                    val valueToIncrease = workArr[valueIndexToDecrease]

                    val differenceBtwTargetDecrease = valueToDecrease - targetValue
                    val differenceBtwTargetIncrease = targetValue - valueToIncrease

                    if (differenceBtwTargetDecrease < differenceBtwTargetIncrease) {
                        workArr[valueIndexToDecrease] = targetValue
                        workArr[valueIndexToIncrease] = valueToIncrease + differenceBtwTargetDecrease

                        totalSteps += differenceBtwTargetDecrease

                        free.push(valueIndexToDecrease)
                        leftOfTarget.push(valueIndexToIncrease)
                    } else {
                        workArr[valueIndexToIncrease] = targetValue
                        workArr[valueIndexToDecrease] = valueToDecrease - differenceBtwTargetIncrease
                        free.push(valueIndexToIncrease)

                        totalSteps += differenceBtwTargetIncrease

                        if (workArr[valueIndexToDecrease] == targetValue) {
                            free.push(valueIndexToDecrease)
                        } else rightOfTarget.push(valueIndexToDecrease)
                    }
                } else {
                    workArr[valueIndexToDecrease] = valueToDecrease - 1
                    if (workArr[valueIndexToDecrease] != targetValue) {
                        rightOfTarget.push(valueIndexToDecrease)
                    } else free.push(valueIndexToDecrease)

                    totalSteps += 1

                    val valueIndexToIncrease = free.pop()
                    workArr[valueIndexToIncrease] = targetValue + 1
                    rightOfTarget.push(valueIndexToIncrease)
                }
            }
        }

        return totalSteps
    }
}