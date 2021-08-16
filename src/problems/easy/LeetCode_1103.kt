package problems.easy

class LeetCode_1103 {

    fun distributeCandies(candies: Int, num_people: Int): IntArray {
        val result = IntArray(num_people)
        var resultArrCursor = 0

        var totalCandies = candies
        var candiesToGive = 1
        while (totalCandies > 0) {
            if (candiesToGive > totalCandies) {
                result[resultArrCursor] = result[resultArrCursor] + totalCandies
                totalCandies = 0
            } else {
                result[resultArrCursor] = result[resultArrCursor] + candiesToGive
                totalCandies -= candiesToGive
                candiesToGive++
                resultArrCursor++

                if (resultArrCursor == result.size) {
                    resultArrCursor = 0
                }
            }
        }

        return result
    }
}