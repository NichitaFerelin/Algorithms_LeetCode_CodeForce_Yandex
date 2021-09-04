package problems.leetcode.medium

class LeetCode_1423 {

    fun maxScore(cardPoints: IntArray, k: Int): Int {
        var stepSum = 0
        var leftCursor = 0
        var rightCursor = cardPoints.lastIndex

        while (leftCursor < k) {
            stepSum += cardPoints[leftCursor]
            leftCursor++
        }
        var maxScore = stepSum

        while (leftCursor != 0) {
            leftCursor--
            stepSum -= cardPoints[leftCursor]

            stepSum += cardPoints[rightCursor]
            rightCursor--

            if (stepSum > maxScore) maxScore = stepSum
        }
        return maxScore
    }
}