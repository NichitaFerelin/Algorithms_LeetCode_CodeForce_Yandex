package problems

/**
 * You're given strings jewels representing the types of stones that are jewels, and stones
 * representing the stones you have. Each character in stones is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * */

class LeetCode_771 {

    fun numJewelsInStones(jewels: String, stones: String): Int {
        val jewelsContainer = HashMap<Char, Unit>(jewels.length, 0.00001F)
        jewels.forEach { jewel -> jewelsContainer[jewel] = Unit }
        return stones.count { stone -> jewelsContainer[stone] != null }
    }
}