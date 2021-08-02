package problems

/**
 * You have n boxes. You are given a binary string boxes of length n,
 * where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
 * In one operation, you can move one ball from a box to an adjacent box.
 * Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
 * Return an array answer of size n, where answer[i] is the minimum number of operations
 * needed to move all the balls to the ith box. Each answer[i] is calculated considering the initial state of the boxes.
 * */

class LeetCode_1769 {

    fun minOperations(boxes: String): IntArray {
        val boxesAsInts = IntArray(boxes.length) { index -> boxes[index].toString().toInt() }
        return IntArray(boxes.length) { index ->
            var totalSteps = 0

            var leftCursor = index - 1
            var rightCursor = index + 1
            while (leftCursor >= 0) {
                if (boxesAsInts[leftCursor] == 1) {
                    totalSteps += index - leftCursor
                }
                leftCursor--
            }

            while (rightCursor < boxesAsInts.size) {
                if (boxesAsInts[rightCursor] == 1) {
                    totalSteps += rightCursor - index
                }
                rightCursor++
            }

            totalSteps
        }
    }
}