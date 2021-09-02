package problems.yandex.algorithms_2_B

import readFromConsole

class C {

    fun alg() {
        val str = readFromConsole()[0]

        var minDifference = 0
        var leftBorder = 0
        var rightBorder = str.lastIndex
        while (leftBorder < rightBorder) {
            if (str[leftBorder] != str[rightBorder]) {
                minDifference++
            }
            leftBorder++
            rightBorder--
        }

        println(minDifference)
    }
}