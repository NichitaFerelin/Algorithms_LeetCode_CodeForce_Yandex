package problems.yandex.algorithms_2_B

import readFromConsole

class E {

    fun alg() {
        val data = readFromConsole()
        val result = data[1].split(" ").map { it.toInt() }.sorted()
        var sum = 0
        for (index in 0 until result.lastIndex) {
            sum += result[index]
        }
        println(sum)
    }
}