package subtask3

class BillCounter {
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val count =   b - (bill.reduce {sum, el -> sum + el} - bill[k]) / 2
        print(b)
        print(count)
        return if (count <= 0)
            "Bon Appetit"
        else
            (count).toString()
    }
}
