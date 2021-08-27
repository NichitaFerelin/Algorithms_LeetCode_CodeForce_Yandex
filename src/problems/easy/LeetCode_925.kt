package problems.easy

class LeetCode_925 {

    fun isLongPressedName(name: String, typed: String): Boolean {
        var nameCursor = 0
        var typedCursor = 0

        while (nameCursor < name.length && typedCursor < typed.length) {
            val currentNameSymbol = name[nameCursor]
            val currentTypedSymbol = typed[typedCursor]

            if (currentNameSymbol != currentTypedSymbol) return false

            typedCursor++
            nameCursor++

            while (typedCursor < typed.length && typed[typedCursor] == typed[typedCursor - 1]
                && (nameCursor >= name.length || name[nameCursor] != typed[typedCursor])
            ) {
                typedCursor++
            }
        }

        return nameCursor >= name.length && typedCursor >= typed.length
    }
}