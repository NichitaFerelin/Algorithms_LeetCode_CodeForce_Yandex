package problems

class YandexSampleContest_A {

    fun execute(data: ArrayList<String>): Array<String> {
        val firstLine = data[0]
        val (firstNumber, secondNumber) = firstLine.split(" ")
        val result = (firstNumber.toLong() + secondNumber.toLong()).toString()
        return arrayOf(result)
    }
}