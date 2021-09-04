package problems.leetcode.easy

class LeetCode_1539 {

    fun findKthPositive(arr: IntArray, k: Int): Int {
        var missing = 0
        var arrCursor = 0
        var currentNum = 1

        while (missing != k) {
            if (arrCursor < arr.size) {
                if (arr[arrCursor] != currentNum) {
                    missing++
                } else arrCursor++
            } else missing++
            currentNum++
        }

        return --currentNum
    }
}