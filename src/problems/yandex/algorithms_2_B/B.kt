package problems.yandex.algorithms_2_B

import readFromConsole
import java.util.*

class B {

    fun alg() {
        val street = readFromConsole()[0]

        var maxDistance = Int.MIN_VALUE
        val undefinedHouses: Queue<Int> = LinkedList()
        var nearestFromLeft: Int? = null
        var nearestFromRight: Int? = null

        var streetCursor = 0
        while (streetCursor < street.length) {
            val buildKey = street[streetCursor].toString().toInt()

            when (buildKey) {
                1 -> undefinedHouses.add(streetCursor)
                2 -> {
                    when {
                        nearestFromLeft == null -> nearestFromLeft = streetCursor
                        nearestFromRight == null -> nearestFromRight = streetCursor
                        else -> {
                            nearestFromLeft = nearestFromRight
                            nearestFromRight = streetCursor
                        }
                    }
                    val maxFromUnpacked = unpackUndefinedHouses(undefinedHouses, nearestFromLeft, nearestFromRight)
                    if (maxFromUnpacked > maxDistance) maxDistance = maxFromUnpacked
                }
                3 -> Unit
            }
            streetCursor += 2
        }
        val maxFromUnpacked = unpackUndefinedHouses(undefinedHouses, nearestFromLeft, nearestFromRight)
        if (maxFromUnpacked > maxDistance) maxDistance = maxFromUnpacked

        val result = maxDistance / 2
        println(result)
    }

    private fun unpackUndefinedHouses(undefinedHouses: Queue<Int>, nearestFromLeft: Int?, nearestFromRight: Int?): Int {
        var max = Int.MIN_VALUE
        while (undefinedHouses.isNotEmpty()) {
            val houseIndex = undefinedHouses.poll()
            val distanceToLeft = if (nearestFromLeft != null) kotlin.math.abs(houseIndex - nearestFromLeft) else null
            val distanceToRight = if (nearestFromRight != null) kotlin.math.abs(nearestFromRight - houseIndex) else null
            when {
                distanceToLeft != null && distanceToRight != null -> {
                    val minDistance = minOf(distanceToLeft, distanceToRight)
                    if (max < minDistance) max = minDistance
                }
                distanceToLeft == null -> if (max < distanceToRight!!) max = distanceToRight
                else -> if (max < distanceToLeft) max = distanceToLeft
            }
        }
        return max
    }
}