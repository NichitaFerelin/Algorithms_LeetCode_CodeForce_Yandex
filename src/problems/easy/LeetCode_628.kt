package problems.easy

class LeetCode_628 {

    fun maximumProduct(nums: IntArray): Int {
        var firstMax: Int? = null
        var secondMax: Int? = null
        var thirdMax: Int? = null

        var firstMin: Int? = null
        var secondMin: Int? = null

        nums.forEach { number ->
            if (thirdMax == null || number > thirdMax!!) {

                if (secondMax == null || number > secondMax!!) {

                    if (firstMax == null || number > firstMax!!) {
                        thirdMax = secondMax
                        secondMax = firstMax
                        firstMax = number
                    } else {
                        thirdMax = secondMax
                        secondMax = number
                    }
                } else thirdMax = number
            }

            if (secondMin == null || number < secondMin!!) {

                if (firstMin == null || number < firstMin!!) {
                    secondMin = firstMin
                    firstMin = number
                } else secondMin = number
            }
        }

        val maxProduct = firstMax!! * secondMax!! * thirdMax!!
        val mixedProduct = firstMax!! * firstMin!! * secondMin!!
        return if (maxProduct > mixedProduct) maxProduct else mixedProduct
    }
}