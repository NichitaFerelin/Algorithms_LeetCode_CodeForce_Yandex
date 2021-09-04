package problems.leetcode.easy

class LeetCode_1974 {

    fun minTimeToType(word: String): Int {
        var totalTime = word.length
        var previousSymbol = 'a'

        word.forEach {
            val travelTime = kotlin.math.abs(it - previousSymbol)
            val difference = kotlin.math.abs(26 - travelTime)
            totalTime += if (travelTime > difference) difference else travelTime
            totalTime++
            previousSymbol = it
        }

        return totalTime
    }
}