package problems.easy

class LeetCode_1207 {

    fun uniqueOccurrences(arr: IntArray): Boolean {
        val numContainer = HashMap<Int, Int>(arr.size)
        arr.forEach { number ->
            numContainer[number] = numContainer.getOrDefault(number, 0) + 1
        }
        val counts = numContainer.values.toSet()
        return counts.size == numContainer.size
    }
}