package problems.yandex.algorithms_3_B

import readFromFile
import writeToFile

class C {
    fun alg() {
        val nums = readFromFile()[0].split(' ')
        val container = LinkedHashMap<String, Int>()
        nums.forEach { number ->
            val itemAtContainer = container[number] ?: 0
            container[number] = itemAtContainer + 1
        }
        var results = ""
        container.forEach { (t, u) ->
            if (u == 1) results += "$t "
        }
        writeToFile(listOf(results))
    }
}