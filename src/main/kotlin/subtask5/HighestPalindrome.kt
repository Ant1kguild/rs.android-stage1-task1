package subtask5

class HighestPalindrome {
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val half = n / 2
        var firstPart = ""
        var changesRequired = 0
        for (value in 0 until half) {
            val first = digitString[value]
            val end = digitString[digitString.length - 1 - value]
            if (changesRequired > k) {
                return "-1"
            }
            if (first != end) {
                changesRequired += 1
                firstPart += if (first.toInt() > end.toInt()) first else end
            } else {
                firstPart += digitString[value]
            }
        }
        if (k - changesRequired > 0) {
            var valMin = 9
            var indMin = 0
            for (i in 0 until half) {
                if (firstPart[i].toString().toInt() < valMin) {
                    indMin = i
                    valMin = firstPart[i].toString().toInt()
                }
            }
            val newFirstPart = firstPart.toCharArray()
            newFirstPart[indMin] = '9'
            firstPart = String(newFirstPart)
        }
        val secondPart = if (n % 2 == 0) firstPart.reversed() else firstPart.slice(0 until half).reversed()
        return "$firstPart$secondPart"
    }
}
