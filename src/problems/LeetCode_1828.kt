package problems

/**
 * You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane.
 * Multiple points can have the same coordinates.
 * You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj)
 * with a radius of rj.
 * For each query queries[j], compute the number of points inside the jth circle. Points on the border of
 * the circle are considered inside.
 * Return an array answer, where answer[j] is the answer to the jth query.
 * */

class LeetCode_1828 {

    fun countPoints(points: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val results = IntArray(queries.size)

        queries.forEachIndexed { index, circleArr ->
            val circleX = circleArr[0]
            val circleY = circleArr[1]
            val circleRadius = circleArr[2]

            var overlapCounter = 0

            points.forEach { pointArr ->
                val pointX = pointArr[0]
                val pointY = pointArr[1]
                if (
                    (pointX - circleX) * (pointX - circleX)
                    + (pointY - circleY) * (pointY - circleY) <= circleRadius * circleRadius
                ) overlapCounter++
            }
            results[index] = overlapCounter
        }

        return results
    }
}