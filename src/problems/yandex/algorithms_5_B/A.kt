package problems.yandex.algorithms_5_B

import readFromFile
import writeToFile

class A {
    fun alg() {
        val data = readFromFile()

        val (size, requests) = data[0].split(" ").map { it.toInt() }
        val dp = IntArray(size)

        var stepSum = 0
        data[1]
            .split(" ")
            .asSequence()
            .map { it.toInt() }
            .onEachIndexed { index, value ->
                stepSum += value
                dp[index] = stepSum
            }
            .toList()

        val resArr = Array(requests) { "" }
        var resArrCursor = 0
        for (index in 2 until data.size) {
            val (leftBorder, rightBorder) = data[index].split(" ").map { it.toInt() - 1 }
            val result = dp[rightBorder] - if (leftBorder > 0) dp[leftBorder - 1] else 0
            resArr[resArrCursor++] = result.toString()
        }
        writeToFile(resArr)
    }
}