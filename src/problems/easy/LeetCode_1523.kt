package problems.easy

class LeetCode_1523 {

    fun countOdds(low: Int, high: Int): Int {
        var odds = 0
        for (number in low..high) {
            if(number % 2 != 0) odds++
        }
        return odds
    }
}