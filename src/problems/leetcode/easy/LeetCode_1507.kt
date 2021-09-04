package problems.leetcode.easy

class LeetCode_1507 {

    fun reformatDate(date: String): String {
        val months = HashMap<String, String>().apply {
            put("Jan", "01")
            put("Feb", "02")
            put("Mar", "03")
            put("Apr", "04")
            put("May", "05")
            put("Jun", "06")
            put("Jul", "07")
            put("Aug", "08")
            put("Sep", "09")
            put("Oct", "10")
            put("Nov", "11")
            put("Dec", "12")
        }

        var dateCursor = 0
        while (date[dateCursor].isDigit()) {
            dateCursor++
        }
        var resultDate = date.substring(0, dateCursor)
        if (resultDate.length == 1) resultDate = "0$resultDate"

        while (date[dateCursor] != ' ') {
            dateCursor++
        }

        val monthStart = ++dateCursor
        while (date[dateCursor] != ' ') {
            dateCursor++
        }
        val resultMonth = months[date.substring(monthStart, dateCursor)]!!

        val resultYear = date.substring(++dateCursor)

        return "$resultYear-$resultMonth-$resultDate"
    }
}