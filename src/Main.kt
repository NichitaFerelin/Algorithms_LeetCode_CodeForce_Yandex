import java.io.File

fun main() {

}

////////////////////////////////////////////////////////
const val inputFileName = "input.txt"
const val outputFileName = "output.txt"

fun readFromFile(): ArrayList<String> {
    val inputStream = File(inputFileName).inputStream()
    return ArrayList<String>().apply {
        inputStream.bufferedReader().forEachLine { add(it) }
        inputStream.close()
    }
}

fun readFromConsole(): List<String> {
    val result = mutableListOf<String>()
    var line = readLine()
    while (line != null) {
        result.add(line)
        line = readLine()
    }
    return result
}

fun writeToFile(data: Array<String>) {
    val file = File(outputFileName).apply { createNewFile() }
    val writer = file.bufferedWriter()
    data.forEach {
        writer.write(it)
        writer.newLine()
    }
    writer.close()
}