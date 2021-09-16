package problems.codeForce

import readFromConsole

class `519B` {
    fun alg() {
        val data = readFromConsole()
        val firstCompileErrors = data[1].split(" ").map { it.toInt() }
        val secondCompileErrors = data[2].split(" ").map { it.toInt() }
        val thirdCompileErrors = data[3].split(" ").map { it.toInt() }

        val firstSum = firstCompileErrors.sum()
        val secondSum = secondCompileErrors.sum()
        val thirdSum = thirdCompileErrors.sum()

        println(firstSum - secondSum)
        println(secondSum - thirdSum)
    }
}