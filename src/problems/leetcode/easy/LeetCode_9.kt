package problems.leetcode.easy

class LeetCode_9 {

    fun isPalindrome(x: Int): Boolean {
        val num = x.toString()
        var leftCursor = 0
        var rightCursor = num.lastIndex
        while (leftCursor < rightCursor) {
            if(num[leftCursor] != num[rightCursor]) {
                return false
            }
            leftCursor++
            rightCursor--
        }

        return true
    }
}