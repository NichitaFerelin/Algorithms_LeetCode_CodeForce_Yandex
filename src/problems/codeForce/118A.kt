package problems.codeForce

import readFromConsole

class `118A` {
    fun alg() {
        val vowels = hashMapOf(
            'a' to Unit,
            'o' to Unit,
            'y' to Unit,
            'e' to Unit,
            'u' to Unit,
            'i' to Unit,
        )

        val str =  readFromConsole()[0]
        val resultStr = StringBuilder(str.length * 2)
        for (symbol in str) {
            val currentSymbol = symbol.toLowerCase()
            if (vowels[currentSymbol] != null) continue
            resultStr.append(".$currentSymbol")
        }

        println(resultStr.toString())
    }
}