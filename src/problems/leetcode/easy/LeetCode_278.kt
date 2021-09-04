package problems.leetcode.easy

class LeetCode_278 {

    /*override*/ fun firstBadVersion(n: Int): Int {
        var leftBorder = 0
        var rightBorder = n

        while (leftBorder <= rightBorder) {
            val middleVersion = leftBorder + (rightBorder - leftBorder) / 2

            /*if (isBadVersion(middleVersion)) {
                rightBorder = middleVersion - 1
            } else leftBorder = middleVersion + 1*/
        }

        return rightBorder + 1
    }
}