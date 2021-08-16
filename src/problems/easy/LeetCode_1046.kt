package problems.easy

class LeetCode_1046 {

    fun lastStoneWeight(stones: IntArray): Int {
        val sortedStones = stones.sortedDescending().toMutableList()
        while (sortedStones.isNotEmpty() && sortedStones.size != 1) {
            val firstStone = sortedStones[0]
            val secondStone = sortedStones[1]

            val difference = firstStone - secondStone

            sortedStones.removeAt(0)
            sortedStones.removeAt(0)

            if (difference != 0) {
                var newPosition = 0
                while(newPosition < sortedStones.size && sortedStones[newPosition] > difference) {
                    newPosition++
                }
                sortedStones.add(newPosition, difference)
            }
        }

        return sortedStones.getOrNull(0) ?: 0
    }
}