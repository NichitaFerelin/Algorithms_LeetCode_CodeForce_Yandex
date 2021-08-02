package problems.easy

/*
* You own a Goal Parser that can interpret a string command.
* The command consists of an alphabet of "G", "()" and/or "(al)" in some order.
* The Goal Parser will interpret "G" as the string "G", "()" as the string "o",
*  and "(al)" as the string "al". The interpreted strings are then concatenated in the original order.
* Given the string command, return the Goal Parser's interpretation of command.
* */

class LeetCode_1678 {

    fun interpret(command: String): String {
        val commandsHolder = mutableListOf<String>()
        val targetCommand = command

        var commandCursor = 0
        while (commandCursor < targetCommand.length) {
            val currentSymbol = targetCommand[commandCursor]
            if (currentSymbol == 'G') {
                commandsHolder.add("G")
                commandCursor++
            } else {
                // current sym is '('
                if (targetCommand[commandCursor + 1] == ')') {
                    commandsHolder.add("o")
                    commandCursor += 2
                } else {
                    // next sym is 'a'
                    commandsHolder.add("al")
                    commandCursor += 4
                }
            }
        }

        var resultStr = ""
        commandsHolder.forEach { resultStr += it }
        return resultStr
    }
}