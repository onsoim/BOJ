import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var s: String?

    while(readLine().also { s = it } != null) {
        val x = s!!.toInt() * 10000000
        val N = readLine()!!.toInt()
        val L = arrayListOf<Int>()

        repeat(N) { L += readLine()!!.toInt() }
        L.sort()

        var i = 0
        var j = N - 1
        var flag = false

        if (N > 1) {
            while (i != j) {
                val sum = L[i] + L[j]
                if (sum == x) {
                    flag = true
                    break
                }
                else if (sum > x) j--
                else i++
            }
        }
        println(if (flag) "yes ${L[i]} ${L[j]}" else "danger")
    }
}