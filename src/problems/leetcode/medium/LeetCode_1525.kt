package problems.leetcode.medium

class LeetCode_1525 {

    fun numSplits(s: String): Int {
        val leftPart = HashMap<Char, Int>()
        val rightPart = HashMap<Char, Int>()
        s.forEach { rightPart[it] = rightPart.getOrDefault(it, 0) + 1 }

        var goodSplits = 0
        s.forEach {
            if (leftPart.size == rightPart.size) goodSplits++

            leftPart[it] = leftPart.getOrDefault(it, 0) + 1

            rightPart[it]?.let { counterAtRight ->
                if (counterAtRight == 1) {
                    rightPart.remove(it)
                } else rightPart[it] = counterAtRight - 1
            }
        }

        return goodSplits
    }
}