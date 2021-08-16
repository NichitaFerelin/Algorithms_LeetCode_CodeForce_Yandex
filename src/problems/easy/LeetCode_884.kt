package problems.easy

class LeetCode_884 {

    fun uncommonFromSentences(s1: String, s2: String): Array<String> {
        val uncommonWords = mutableListOf<String>()

        val s1Words = s1.split(" ")
        val s2Words = s2.split(" ")

        var s1Cursor = 0
        var s2Cursor = 0
        while (s1Cursor < s1Words.size && s2Cursor < s2Words.size) {
            if (s1Words[s1Cursor] != s2Words[s2Cursor]) {
                uncommonWords.add(s1Words[s1Cursor])
                uncommonWords.add(s2Words[s2Cursor])
            }
            s1Cursor++
            s2Cursor++
        }

        while (s1Cursor < s1Words.size) uncommonWords.add(s1Words[s1Cursor++])
        while (s2Cursor < s2Words.size) uncommonWords.add(s2Words[s2Cursor++])

        return Array(uncommonWords.size) { uncommonWords[it] }
    }
}