package problems.medium

class LeetCode_1910 {

    fun removeOccurrences(s: String, part: String): String {
        val str = s.toCharArray().toMutableList()

        var strCursor = 0
        while (strCursor < str.size) {
            if (str[strCursor] == part[0]) {
                var partCursor = 1
                var subStrCursor = strCursor + 1
                while (partCursor < part.length && subStrCursor < str.size && str[subStrCursor] == part[partCursor]) {
                    subStrCursor++
                    partCursor++
                }

                if (partCursor == part.length) {
                    var removeTimes = part.length
                    while (removeTimes > 0) {
                        str.removeAt(strCursor)
                        removeTimes--
                    }
                    strCursor = 0
                } else strCursor++
            } else strCursor++
        }

        var resultStr = ""
        str.forEach { resultStr += it }
        return resultStr
    }
}