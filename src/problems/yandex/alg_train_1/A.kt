package problems.yandex.alg_train_1

import readFromConsole

class A {

    fun execute() {
        val consoleData = readFromConsole()
        val (roomTemperature, targetTemperature) = consoleData[0].split(" ").map { it.toInt() }
        val result = when (consoleData[1]) {
            "fan" -> roomTemperature
            "auto" -> targetTemperature
            "freeze" -> if (roomTemperature < targetTemperature) roomTemperature else targetTemperature
            else -> if (roomTemperature > targetTemperature) roomTemperature else targetTemperature
        }

        println(result)
    }
}