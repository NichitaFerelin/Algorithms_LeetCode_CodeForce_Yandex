package problems.leetcode.easy

class LeetCode_1945 {

    fun getLucky(s: String, k: Int): Int {
        var strNumber = ""
        s.forEach { strNumber += (it.toInt() - 96).toString() }

        var transformsRemain = k
        while (transformsRemain > 0) {
            var sum = 0
            strNumber.forEach { sum += it.toString().toInt() }
            strNumber = sum.toString()
            transformsRemain--
        }

        return strNumber.toInt()
    }
}