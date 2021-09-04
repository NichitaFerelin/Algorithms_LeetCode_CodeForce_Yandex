package problems.leetcode.medium

class LeetCode_1807 {
    fun evaluate(s: String, knowledge: List<List<String>>): String {
        val knowledgeContainer = HashMap<String, String>()
        knowledge.forEach { knowledgeContainer[it[0]] = it[1] }

        var resultStr = ""
        var strCursor = 0
        while (strCursor < s.length) {
            val currentSymbol = s[strCursor]

            if (currentSymbol.isLetter()) {
                resultStr += currentSymbol
                strCursor++
            } else {
                strCursor++

                var currentKnowledge = ""
                while (s[strCursor] != ')') {
                    currentKnowledge += s[strCursor]
                    strCursor++
                }
                strCursor++
                resultStr += knowledgeContainer[currentKnowledge] ?: "?"
            }
        }

        return resultStr
    }
}