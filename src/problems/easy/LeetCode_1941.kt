package problems.easy

class LeetCode_1941 {

    fun areOccurrencesEqual(s: String): Boolean {
        val occurrenceContainer = HashMap<Char, Int>(s.length)
        s.forEach { symbol ->
            val atContainer = occurrenceContainer[symbol]
            if (atContainer == null) {
                occurrenceContainer[symbol] = 1
            } else occurrenceContainer[symbol] = atContainer + 1
        }

        val occurrence = occurrenceContainer[s.last()]!!
        occurrenceContainer.forEach {
            if (it.value != occurrence) {
                return false
            }
        }

        return true
    }
}