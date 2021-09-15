package problems.codeForce

import readFromConsole

class `466A` {
    fun alg() {
        val data = readFromConsole()[0].split(" ")
        val totalMoves = data[0].toInt()
        val oneMoveCost = data[2].toInt()

        val movesPerOneTicker = data[1].toInt()
        val oneTickerCost = data[3].toInt()

        var minCost = 0
        var movesRemain = totalMoves

        if (oneTickerCost > movesPerOneTicker * oneMoveCost) {
            minCost = oneMoveCost * movesRemain
            movesRemain = 0
        }

        while (movesRemain > 0) {
            when {
                oneTickerCost <= oneMoveCost || oneTickerCost < oneMoveCost * movesRemain -> {
                    minCost += oneTickerCost
                    movesRemain -= movesPerOneTicker
                }
                else -> {
                    minCost += oneMoveCost
                    movesRemain--
                }
            }
        }

        println(minCost)
    }
}