package problems.yandex.mobile_example_contest

import readFromFile
import writeToFile

class A {
    fun alg() {
        val data = readFromFile()
        val result = Array(data.size) { "" }
        data.forEach {
            val priorityStartIndex = it.indexOfFirst { symbol -> symbol.isDigit() }
            var priorityEndIndex = priorityStartIndex
            while (priorityEndIndex < it.length && it[priorityEndIndex].isDigit()) {
                priorityEndIndex++
            }

            val string = it.substring(0, priorityStartIndex) + it.substring(priorityEndIndex, it.length)
            val priority = it.substring(priorityStartIndex, priorityEndIndex).toInt() - 1
            result[priority] = string
        }
        writeToFile(result)
    }
}