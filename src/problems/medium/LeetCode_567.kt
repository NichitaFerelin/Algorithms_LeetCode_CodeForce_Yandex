package problems.medium

class LeetCode_567 {

    fun checkInclusion(s1: String, s2: String): Boolean {
        val permutationChars = HashMap<Char, Int>()
        s1.forEach { permutationChars[it] = permutationChars.getOrDefault(it, 0) + 1 }

        var strCursor = 0
        while (strCursor < s2.length) {
            val currentSymbol = s2[strCursor]
            if (permutationChars[currentSymbol] != null) {
                val tempMap = permutationChars.clone() as HashMap<Char, Int>

                for (index in strCursor until s2.length) {
                    val stepSymbol = s2[index]
                    val symbolCounterAtContainer = tempMap[stepSymbol]

                    if (symbolCounterAtContainer != null) {
                        if (symbolCounterAtContainer - 1 == 0) {
                            tempMap.remove(stepSymbol)
                        } else tempMap[stepSymbol] = symbolCounterAtContainer - 1
                    } else break
                }

                if (tempMap.isEmpty()) {
                    return true
                }
            }
            strCursor++
        }

        return false
    }
}