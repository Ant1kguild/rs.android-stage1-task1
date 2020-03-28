package subtask1

class HappyArray {
    fun convertToHappy(sadArray: IntArray): IntArray {
        fun swapArray(array: IntArray): IntArray {
            val result = array.filterIndexed { index, value ->
                if (index > 0 && index < array.size - 1)
                    value < array[index - 1] + array[index + 1]
                else
                    true

            }
            return if (result.size == array.size)
                result.toIntArray()
            else
                swapArray(result.toIntArray())
        }
        return swapArray(sadArray)
    }
}
