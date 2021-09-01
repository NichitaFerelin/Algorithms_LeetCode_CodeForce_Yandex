package problems.yandex.algorithms_1_B

import readFromConsole

class C {

    fun alg() {
        val data = readFromConsole()[0]

        var dateCursor = 0
        while (data[dateCursor] != ' ') {
            dateCursor++
        }

        val dayOrMonth = data.substring(0, dateCursor).toInt()
        if (dayOrMonth > 12) {
            println(1)
            return
        }

        val secondNumStart = ++dateCursor
        while (data[dateCursor] != ' ') {
            dateCursor++
        }

        val monthOrDay = data.substring(secondNumStart, dateCursor).toInt()
        val result = when {
            dayOrMonth == monthOrDay -> 1
            monthOrDay > 12 -> 1
            else -> 0
        }

        println(result)
    }
}