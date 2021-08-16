package problems.easy

class LeetCode_1394 {

    fun findLucky(arr: IntArray): Int {
        val numbers = HashMap<Int, Int>(arr.size)
        arr.forEach { numbers[it] = numbers.getOrDefault(it, 0) + 1 }

        var max = -1
        numbers.forEach { map ->
            if (map.key == map.value && map.key > max) max = map.key
        }

        return max
    }
}