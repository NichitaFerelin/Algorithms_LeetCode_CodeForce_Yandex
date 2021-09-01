package problems.yandex.algorithms_1_B

import readFromConsole

class D {

    fun alg() {
        val data = readFromConsole()
        val houses = data[1].split(" ")
        val result = houses[houses.size / 2].toInt()
        println(result)
    }
}