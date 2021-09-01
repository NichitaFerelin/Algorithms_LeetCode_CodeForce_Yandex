package problems.yandex.algorithms_1_B

import readFromConsole

class A {

    fun alg() {
        val data = readFromConsole()
        val finishCode = data[0].toInt()
        val iteractorCode = data[1].toInt()
        val checkerCode = data[2].toInt()

        val result = when (iteractorCode) {
            0 -> if (finishCode != 0) 3 else checkerCode
            1 -> checkerCode
            4 -> if (finishCode != 0) 3 else 4
            6 -> 0
            7 -> 1
            else -> iteractorCode
        }

        println(result)
    }
}