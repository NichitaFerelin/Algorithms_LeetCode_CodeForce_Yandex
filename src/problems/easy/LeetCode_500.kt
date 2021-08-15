package problems.easy

class LeetCode_500 {

    fun findWords(words: Array<String>): Array<String> {
        val firstRowContainer = HashMap<Char, Unit>(10).apply {
            put('q', Unit)
            put('w', Unit)
            put('e', Unit)
            put('r', Unit)
            put('t', Unit)
            put('y', Unit)
            put('u', Unit)
            put('i', Unit)
            put('o', Unit)
            put('p', Unit)
        }

        val secondRowContainer = HashMap<Char, Unit>(10).apply {
            put('a', Unit)
            put('s', Unit)
            put('d', Unit)
            put('f', Unit)
            put('g', Unit)
            put('h', Unit)
            put('j', Unit)
            put('k', Unit)
            put('l', Unit)
        }

        val thirdRowContainer = HashMap<Char, Unit>(10).apply {
            put('z', Unit)
            put('x', Unit)
            put('c', Unit)
            put('v', Unit)
            put('b', Unit)
            put('n', Unit)
            put('m', Unit)
        }

        val result = mutableListOf<String>()
        for (word in words) {
            val availableRows = mutableListOf(firstRowContainer.keys, secondRowContainer.keys, thirdRowContainer.keys)
            for (symbol in word) {
                val lowerCaseSym = symbol.toLowerCase()
                if (firstRowContainer[lowerCaseSym] == null) availableRows.remove(firstRowContainer.keys)
                if (secondRowContainer[lowerCaseSym] == null) availableRows.remove(secondRowContainer.keys)
                if (thirdRowContainer[lowerCaseSym] == null) availableRows.remove(thirdRowContainer.keys)

                if (availableRows.isEmpty()) break
            }

            if (availableRows.isNotEmpty()) result.add(word)
        }

        return Array(result.size) { result[it] }
    }
}