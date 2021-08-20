package problems.easy

class LeetCode_383 {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val availableChars = HashMap<Char, Int>()
        magazine.forEach { availableChars[it] = availableChars.getOrDefault(it, 0) + 1 }
        ransomNote.forEach {
            val counterAtContainer = availableChars[it]
            if (counterAtContainer == null || counterAtContainer <= 0) {
                return false
            } else {
                availableChars[it] = counterAtContainer - 1
            }
        }

        return true
    }
}