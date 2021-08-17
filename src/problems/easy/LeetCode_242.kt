package problems.easy

class LeetCode_242 {

    fun isAnagram(s: String, t: String): Boolean {
        val sMap = HashMap<Char, Int>(s.length * 3)
        val tMap = HashMap<Char, Int>(t.length * 3)
        s.forEach { sMap[it] = sMap.getOrDefault(it, 0) + 1 }
        t.forEach { tMap[it] = tMap.getOrDefault(it, 0) + 1 }
        sMap.forEach {
            if (it.value != tMap[it.key]) {
                return false
            } else {
                tMap.remove(it.key)
            }
        }

        return tMap.isEmpty()
    }
}