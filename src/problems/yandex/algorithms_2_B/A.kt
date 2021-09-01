package problems.yandex.algorithms_2_B

class A {

    fun alg() {
        var lastMax = Int.MIN_VALUE
        var lastInput = Int.MIN_VALUE
        var counter = 1

        while (lastInput != 0) {
            lastInput = readLine()?.toInt() ?: 0

            if (lastInput == 0) continue

            if (lastInput > lastMax) {
                lastMax = lastInput
                counter = 1
            } else if (lastInput == lastMax) counter++
        }

        println(counter)
    }
}