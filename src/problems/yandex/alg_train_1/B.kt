package problems.yandex.alg_train_1

import readFromConsole

class B {

    fun execute() {
        val consoleData = readFromConsole()
        val firstPart = consoleData[0].toInt()
        val secondPart = consoleData[1].toInt()
        val thirdPart = consoleData[2].toInt()

        val result =
            if (firstPart + secondPart > thirdPart
                && secondPart + thirdPart > firstPart
                && firstPart + thirdPart > secondPart
            ) "YES" else "NO"

        println(result)
    }
}