package problems.yandex.algorithms_4_B

import readFromFile
import writeToFile

class C {
    fun alg() {
        val rows = readFromFile()
        val wordsContainer = HashMap<String, Int>()

        rows.forEach { row ->
            val wordsAtRow = row.split(' ')
            wordsAtRow.forEach { word ->
                val itemAtContainer = wordsContainer[word] ?: 0
                wordsContainer[word] = itemAtContainer + 1
            }
        }

        val pairsList = wordsContainer
            .map { Pair(it.key, it.value) }
            .sortedWith { pair1, pair2 ->
                if (pair1.second == pair2.second) {
                    when {
                        pair1.first == pair2.first -> 0
                        pair1.first > pair2.first -> 1
                        else -> -1
                    }
                } else {
                    when {
                        pair1.second > pair2.second -> -1
                        else -> 1
                    }
                }
            }
        val result = pairsList.map { it.first }
        writeToFile(result)
    }
}