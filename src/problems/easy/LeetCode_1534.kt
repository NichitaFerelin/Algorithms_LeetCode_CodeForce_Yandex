package problems.easy

/**
 * Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.

A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:

0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c
Where |x| denotes the absolute value of x.

Return the number of good triplets.
 * */

class LeetCode_1534 {

    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        var tripletsCounter = 0

        for (outIndex in 0 until arr.size - 2) {
            val outNumber = arr[outIndex]

            for (inIndex in (outIndex + 1) until arr.size - 1) {

                val inNumber = arr[inIndex]
                if (kotlin.math.abs(outNumber - inNumber) <= a) {

                    for (index in (inIndex + 1) until arr.size) {
                        val number = arr[index]
                        val diffBtwSecond = kotlin.math.abs(inNumber - number)
                        val diffBtwFirst = kotlin.math.abs(outNumber - number)

                        if (diffBtwFirst <= c && diffBtwSecond <= b) {
                            tripletsCounter++
                        }
                    }
                }
            }
        }

        return tripletsCounter
    }
}