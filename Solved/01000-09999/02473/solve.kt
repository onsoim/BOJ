import java.io.*

import kotlin.math.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    val L = readLine()!!.split(" ").map { it.toLong() }.sorted()

    var I = 0
    var J = N - 1
    var K = 0
    var D = Long.MAX_VALUE

    repeat(N - 2) { k ->
        var i = 0
        var j = N - 1

        while (i < j) {
            val sum = L[i] + L[j] + L[k + 1]

            if (abs(sum) < D) {
                I = i
                J = j
                K = k + 1
                D = abs(sum)
            }

            if (sum > 0) j--
            else i++

            if (i == k + 1) i++
            if (j == k + 1) j--
        }
    }
    println(listOf(L[I], L[J], L[K]).sorted().joinToString(" "))
}