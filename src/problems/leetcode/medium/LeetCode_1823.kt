package problems.leetcode.medium

class LeetCode_1823 {

    fun findTheWinner(n: Int, k: Int): Int {
        val friends = MutableList(n) { index -> index + 1 }

        var friendsCursor = 0
        while (friends.size != 1) {
            var stepsToRight = k - 1
            while (stepsToRight-- > 0) {
                friendsCursor++

                if (friendsCursor >= friends.size) {
                    friendsCursor = 0
                }
            }

            friends.removeAt(friendsCursor)
            if (friendsCursor >= friends.size) {
                friendsCursor = 0
            }
        }

        return friends[0]
    }
}