package problems.leetcode.easy

class LeetCode_1550 {

    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        var odds = 0
        arr.forEach {
            if (it % 2 != 0) {
                odds++

                if (odds == 3) {
                    return true
                }
            } else odds = 0
        }

        return false
    }
}