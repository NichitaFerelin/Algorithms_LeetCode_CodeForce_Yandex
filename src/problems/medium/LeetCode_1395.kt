package problems.medium

class LeetCode_1395 {

    fun numTeams(rating: IntArray): Int {
        var totalTeams = 0

        rating.forEachIndexed { outIndex, firstItem ->
            for (inIndex in outIndex + 1 until rating.size - 1) {
                val secondItem = rating[inIndex]
                for (index in inIndex + 1 until rating.size) {
                    val thirdItem = rating[index]
                    if ((firstItem < secondItem && secondItem < thirdItem) || firstItem > secondItem && secondItem > thirdItem) {
                        totalTeams++
                    }
                }
            }
        }

        return totalTeams
    }
}