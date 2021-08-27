package problems.easy

class LeetCode_434 {

    fun countSegments(s: String): Int {
        var segments = 0
        var segmentBefore = false

        var strCursor = 0
        while (strCursor < s.length) {
            if (s[strCursor] == ' ') {
                if (segmentBefore) {
                    segmentBefore = false
                    segments++
                }

                strCursor++
                while (strCursor < s.length && s[strCursor] == ' ') {
                    strCursor++
                }
            } else {
                segmentBefore = true
                strCursor++
            }
        }

        if (segmentBefore) segments++

        return segments
    }
}