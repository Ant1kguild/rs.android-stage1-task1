package subtask4

class StringParser {
    fun getResult(inputString: String): Array<String> {
        val temp = mutableListOf<IndexedValue<Char>>()
        val bracketsOnly =
            inputString.withIndex().filter { isOpen(it.value) || isClose(it.value) }
        val openBrackets = bracketsOnly.filter { isOpen(it.value) }
        val result = Array<String>(openBrackets.size) { _ -> "_" }

        for (state in bracketsOnly) {
            when {
                isOpen(state.value) -> {
                    temp.add(temp.size, state)
                }
                isClose(state.value) -> {
                    val lastInd = temp.indexOfLast { it.value == open(state.value) }
                    val start = temp.removeAt(lastInd)
                    val startInt = start.index + 1
                    val endInt = state.index - 1
                    val index = openBrackets.indexOfFirst { it.index == start.index }
                    result[index] = inputString.slice(startInt..endInt)
                }
            }
        }
        return result
    }

    private fun open(value: Char): Char {
        return when (value) {
            '>' -> '<'
            ')' -> '('
            ']' -> '['
            else -> '_'
        }
    }

    private fun isOpen(value: Char): Boolean {
        return value == '<' || value == '(' || value == '['
    }

    private fun isClose(value: Char): Boolean {
        return value == '>' || value == ')' || value == ']'
    }
}
