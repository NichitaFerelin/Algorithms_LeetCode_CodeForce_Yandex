package problems.leetcode.easy

class LeetCode_1576 {

    fun modifyString(s: String): String {
        val result = StringBuilder(s)

        for (index in result.indices) {
            val currentSymbol = result[index]
            if (currentSymbol != '?') continue

            when {
                index - 1 < 0 && index + 1 >= result.length -> return "a"
                index - 1 < 0 -> {
                    for (symbol in 'a'..'z') {
                        if (symbol != result[index + 1]) {
                            result[index] = symbol
                            break
                        }
                    }
                }
                index + 1 >= result.length -> {
                    for (symbol in 'a'..'z') {
                        if (symbol != result[index - 1]) {
                            result[index] = symbol
                            break
                        }
                    }
                }
                else -> {
                    for (symbol in 'a'..'z') {
                        if (symbol != result[index - 1] && symbol != result[index + 1]) {
                            result[index] = symbol
                            break
                        }
                    }
                }
            }
        }
        return result.toString()
    }
}