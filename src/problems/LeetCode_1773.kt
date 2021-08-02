package problems

/**
 * You are given an array items, where each items[i] = [typei, colori, namei]
 * describes the type, color, and name of the ith item. You are also given a
 * rule represented by two strings, ruleKey and ruleValue.
 * The ith item is said to match the rule if one of the following is true:
 * ruleKey == "type" and ruleValue == typei.
 * ruleKey == "color" and ruleValue == colori.
 * ruleKey == "name" and ruleValue == namei.
 * Return the number of items that match the given rule.
 * */

class LeetCode_1773 {

    fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
        val ruleIndexToCompare = when (ruleKey[0]) {
            't' -> 0
            'c' -> 1
            'n' -> 2
            else -> -1
        }

        var matchCounter = 0
        items.forEach { item ->
            if (item[ruleIndexToCompare] == ruleValue) {
                matchCounter++
            }
        }

        return matchCounter
    }
}