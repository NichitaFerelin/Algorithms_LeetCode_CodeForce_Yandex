package problems.easy

class LeetCode_414 {

    fun thirdMax(nums: IntArray): Int {
        var firstMax: Int? = null
        var secondMax: Int? = null
        var thirdMax: Int?  = null

        nums.forEach { number ->
            if (thirdMax == null || number > thirdMax!!) {

                if (secondMax == null || number > secondMax!!) {

                    if (firstMax == null || number > firstMax!!) {
                        thirdMax = secondMax
                        secondMax = firstMax
                        firstMax = number
                    } else if (firstMax != number) {
                        thirdMax = secondMax
                        secondMax = number
                    }
                } else if (secondMax != number) thirdMax = number
            }
        }
        return thirdMax ?: firstMax!!
    }
}