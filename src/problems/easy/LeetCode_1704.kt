package problems.easy

/**
 * You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.
 * */

class LeetCode_1704 {

    fun halvesAreAlike(s: String): Boolean {
        val vowels = HashMap<Char, Unit>(10, 0.000001F).apply {
            this['a'] = Unit
            this['e'] = Unit
            this['i'] = Unit
            this['o'] = Unit
            this['u'] = Unit
            this['A'] = Unit
            this['E'] = Unit
            this['I'] = Unit
            this['O'] = Unit
            this['U'] = Unit
        }
        val firstStr = s.substring(0, s.length / 2)
        val secondStr = s.substring(s.length / 2, s.length)
        return firstStr.count { vowels[it] != null } == secondStr.count { vowels[it] != null }
    }
}