package problems.easy

/**
 * On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in seconds to visit all the points in the order given by points.

You can move according to these rules:

In 1 second, you can either:
move vertically by one unit,
move horizontally by one unit, or
move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
You have to visit the points in the same order as they appear in the array.
You are allowed to pass through points that appear later in the order, but these do not count as visits.
 * */

class LeetCode_1266 {

    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var seconds = 0
        var currentX = points[0][0]
        var currentY = points[0][1]

        for (index in 1 until points.size) {
            val diffByX = kotlin.math.abs(points[index][0] - currentX)
            val diffByY = kotlin.math.abs(points[index][1] - currentY)
            val commonDiff = if (diffByX > diffByY) diffByX else diffByY
            seconds += commonDiff

            currentX = points[index][0]
            currentY = points[index][1]
        }

        return seconds
    }
}