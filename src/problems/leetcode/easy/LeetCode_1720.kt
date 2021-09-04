package problems.leetcode.easy

class LeetCode_1720 {

    fun decode(encoded: IntArray, first: Int): IntArray {
        val decoded = IntArray(encoded.size + 1)
        decoded[0] = first
        var decodedCursor = 1
        for (index in 0 until encoded.size) {
            decoded[decodedCursor] = encoded[index].xor(decoded[decodedCursor - 1])
            decodedCursor++
        }
        return decoded
    }
}