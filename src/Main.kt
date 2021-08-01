import problems.YandexSampleContest_A
import java.io.File

val problem: Problem = YandexSampleContest_A()

fun main() {
    val data = read()
    val result = problem.execute(data)
    write(result)
}

////////////////////////////////////////////////////////
const val inputFileName = "input.txt"
const val outputFileName = "output.txt"

/**
 * @return data by lines.
 * For example:
 *  input.txt {
 *      1 2 3 4
 *      54
 *      text
 *  }
 *
 *  Read result = {
 *      { 1 2 3 4 },
 *      { 54 },
 *      { text }
 *   }
 * */
fun read(): ArrayList<String> {
    val inputStream = File(inputFileName).inputStream()
    return ArrayList<String>().apply {
        inputStream.bufferedReader().forEachLine { add(it) }
        inputStream.close()
    }
}

fun write(data: Array<String>) {
    val file = File(outputFileName).apply { createNewFile() }
    val writer = file.bufferedWriter()
    data.forEach {
        writer.write(it)
        writer.newLine()
    }
    writer.close()
}

abstract class Problem {
    abstract fun execute(data: ArrayList<String>): Array<String>
}