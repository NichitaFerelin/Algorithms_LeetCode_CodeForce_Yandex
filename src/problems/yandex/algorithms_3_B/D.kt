package problems.yandex.algorithms_3_B

import readFromFile
import writeToFile
import java.util.*

class D {
    fun alg() {
        val data = readFromFile()
        val maxNumber = data[0].toLong()
        val mayBeNumbers = TreeMap<Long, Unit>()

        for (index in 1 until data.size - 2 step 2) {
            val answer = data[index + 1]
            val questionRow = data[index].split(' ')

            if (answer == "NO") {
                questionRow
                    .map { it.toLong() }
                    .forEach { mayBeNumbers.remove(it) }
            } else {
                val questionNumbers = hashMapOf<Long, Unit>()
                questionRow.forEach { numStr ->
                    val number = numStr.toLong()
                    questionNumbers[number] = Unit
                }

                mayBeNumbers.keys.forEach { number ->
                    if (questionNumbers[number] == null) {
                        mayBeNumbers.remove(number)
                    }
                }
                for (number in questionNumbers.keys) {
                    if (number > maxNumber) {
                        continue
                    } else mayBeNumbers[number] = Unit
                }
            }
        }
        var result = ""
        mayBeNumbers.keys.forEach { result += "$it " }
        writeToFile(listOf(result))
    }
}