package subtask2

class MiniMaxSum {
    fun getResult(input: IntArray): IntArray {
        val test = input.reduce { it1, it2  -> it1 + it2}
        return listOf(
            test - input.max()!!,
            test - input.min()!!
        ).toIntArray()
    }
}
