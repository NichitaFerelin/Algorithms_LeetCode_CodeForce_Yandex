package problems.yandex.algorithms_1_B

import readFromConsole

class B {

    fun alg() {
        val data = readFromConsole()[0].split(" ")

        val stations = data[0].toInt()
        val firstStation = data[1].toInt()
        val secondStation = data[2].toInt()
        val (enterStation, exitStation) = if (firstStation < secondStation) {
            arrayOf(firstStation, secondStation)
        } else arrayOf(secondStation, firstStation)

        val directStepStations = kotlin.math.abs(exitStation - enterStation) - 1
        val backStepStations = stations - exitStation + enterStation - 1
        val result = if (directStepStations < backStepStations) directStepStations else backStepStations

        println(result)
    }
}