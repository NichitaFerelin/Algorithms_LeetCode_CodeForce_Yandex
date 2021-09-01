package problems.yandex.algorithms_1_B

import readFromConsole

class E {

    fun alg() {
        val data = readFromConsole()

        val leg = data[0].toInt()
        val (x, y) = data[1].split(" ").map { it.toInt() }

        val alpha = (0 - x) * (leg - 0) - (0 - 0) * (0 - y)
        val beta = (0 - x) * (0 - leg) - (leg - 0) * (leg - y)
        val gamma = (leg - x) * (0 - 0) - (0 - leg) * (0 - y)

        val result = when {
            alpha >= 0 && beta >= 0 && gamma >= 0 -> 0
            alpha <= 0 && beta <= 0 && gamma <= 0 -> 0
            else -> {
                val alphaDistance = kotlin.math.abs(x + y)
                val betaDistance = kotlin.math.abs(kotlin.math.abs(x - leg) + y)
                val gammaDistance = kotlin.math.abs(x + kotlin.math.abs(y - leg))

                val nearestTop = when {
                    alphaDistance <= betaDistance && betaDistance <= gammaDistance -> 1
                    betaDistance <= alphaDistance && (alphaDistance <= gammaDistance || betaDistance <= gammaDistance) -> 2
                    else -> 3
                }
                nearestTop
            }
        }

        println(result)
    }
}