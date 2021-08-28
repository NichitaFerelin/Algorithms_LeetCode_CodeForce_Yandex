package problems.easy

import java.util.*

class LeetCode_345 {

    fun reverseVowels(s: String): String {
        val vowels = HashMap<Char, Unit>()
        vowels['a'] = Unit
        vowels['e'] = Unit
        vowels['i'] = Unit
        vowels['o'] = Unit
        vowels['u'] = Unit

        vowels['A'] = Unit
        vowels['E'] = Unit
        vowels['I'] = Unit
        vowels['O'] = Unit
        vowels['U'] = Unit

        val vowelsReversed = Stack<Char>()
        s.forEach { if (vowels[it] != null) vowelsReversed.push(it) }

        val result = StringBuilder(s)
        result.forEachIndexed { index, symbol ->
            if (vowels[symbol] != null) {
                result[index] = vowelsReversed.pop()
            }
        }
        return result.toString()
    }
}