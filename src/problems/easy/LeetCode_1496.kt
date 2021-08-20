package problems.easy

class LeetCode_1496 {

    fun isPathCrossing(path: String): Boolean {
        val visitedPoints = HashMap<String, Unit>()

        var x = 0
        var y = 0
        visitedPoints["$x-$y"] = Unit

        path.forEach { symbol ->
            when (symbol) {
                'N' -> y++
                'E' -> x++
                'S' -> y--
                'W' -> x--
            }
            val key = "$x-$y"
            if (visitedPoints[key] != null) return false

            visitedPoints[key] = Unit
        }

        return true
    }
}