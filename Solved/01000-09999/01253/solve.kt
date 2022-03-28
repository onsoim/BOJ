import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    val L = readLine()!!.split(" ").map { it.toInt() }.sorted()
    var good = 0

    repeat(N) {
        var i = if (it == 0) 1 else 0
        var j = if (it == N - 1) N - 2 else N - 1

        while (i < j) {
            val sum = L[i] + L[j]

            if (sum == L[it]) {
                good++
                break
            }
            else if (sum > L[it]) { if (--j == it) j-- }
            else if (++i == it) i++
        }
    }

    println(good)
}