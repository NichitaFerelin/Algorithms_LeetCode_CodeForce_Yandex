package problems.leetcode.medium

class LeetCode_692 {

    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val wordsFrequencyContainer = HashMap<String, Int>()
        words.forEach { wordsFrequencyContainer[it] = wordsFrequencyContainer.getOrDefault(it, 0) + 1 }

        val resultWords = wordsFrequencyContainer.keys.sortedWith(Comparator { s1, s2 ->
            val frequencyFirst = wordsFrequencyContainer[s1]!!
            val frequencySecond = wordsFrequencyContainer[s2]!!

            when {
                frequencyFirst == frequencySecond -> if (s1 < s2) -1 else 1
                frequencyFirst < frequencySecond -> 1
                else -> -1
            }
        })

        val result = mutableListOf<String>()
        var index = 0
        while (index < resultWords.size && index < k) {
            result.add(resultWords[index])
            index++
        }

        return result
    }
}