package problems.easy

class LeetCode_389 {

    fun findTheDifference(s: String, t: String): Char {
        val sMap = HashMap<Char, Int>()
        s.forEach { sMap[it] = sMap.getOrDefault(it, 0) + 1 }

        val tMap = HashMap<Char, Int>()
        t.forEach { tMap[it] = tMap.getOrDefault(it, 0) + 1 }

        tMap.forEach { map ->
            if (sMap[map.key] == null || sMap[map.key] != map.value) return map.key
        }

        return ' '
    }
}