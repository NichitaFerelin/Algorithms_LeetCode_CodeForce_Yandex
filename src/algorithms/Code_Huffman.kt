package algorithms

class Code_Huffman {

    class Node(val symbol: Char?, val left: Node? = null, val right: Node? = null)

    fun encrypt(word: String): Pair<Node?, String> {
        val symbolsContainer = HashMap<Char, Int>(word.length)
        word.forEach { symbolsContainer[it] = symbolsContainer.getOrDefault(it, 0) + 1 }
        val sortedSymbols = symbolsContainer.toList().sortedBy { it.second }

        if (sortedSymbols.size == 1) {
            return Pair(Node(sortedSymbols[0].first), "0")
        }

        val resultCodesContainer = HashMap<Char, String>()

        val lowerNodeLeft = Node(sortedSymbols[0].first)
        val lowerNodeRight = Node(sortedSymbols[1].first)
        var lastTopNode = Node(null, lowerNodeLeft, lowerNodeRight)

        resultCodesContainer[lowerNodeLeft.symbol!!] = "0"
        resultCodesContainer[lowerNodeRight.symbol!!] = "1"

        var symbolsCursor = 2
        while (symbolsCursor < sortedSymbols.size) {
            val currentSymbol = sortedSymbols[symbolsCursor++]
            val newNode = Node(currentSymbol.first)
            val newTopNode = Node(null, newNode, lastTopNode)
            resultCodesContainer[newNode.symbol!!] = "0"

            sortedSymbols.forEach { pair ->
                if (pair.first == newNode.symbol) {
                    return@forEach
                }
                resultCodesContainer[pair.first] = "1" + resultCodesContainer.getOrDefault(pair.first, "")
            }

            lastTopNode = newTopNode
        }

        var resultStr = ""
        word.forEach { symbol ->
            val code = resultCodesContainer[symbol]!!
            resultStr += code
        }
        return Pair(lastTopNode, resultStr)
    }

    fun decrypt(rootNode: Node?, code: String): String {
        if (rootNode == null) {
            return ""
        }

        val resultCodesContainer = HashMap<Char, String>()
        var currentNode = rootNode
        var currentPath = ""
        while (currentNode!!.symbol == null) {
            val leftSymbol = currentNode.left!!.symbol!!
            resultCodesContainer[leftSymbol] = currentPath + "0"
            currentPath += "1"
            currentNode = currentNode.right
        }
        resultCodesContainer[currentNode.symbol!!] = currentPath

        var resultStr = ""

        var codeCursor = 0
        var currentCode = ""
        while (codeCursor < code.length) {
            currentCode += code[codeCursor++]
            val symbolByCode = resultCodesContainer.values.find { it == currentCode }

            if (symbolByCode != null) {
                var stepNode = rootNode
                var symbolByCodeCursor = 0

                while (symbolByCodeCursor < symbolByCode.length) {
                    stepNode = if (symbolByCode[symbolByCodeCursor] == '0') stepNode!!.left else stepNode!!.right
                    symbolByCodeCursor++
                }
                resultStr += stepNode!!.symbol
                currentCode = ""
            }
        }

        return resultStr
    }
}