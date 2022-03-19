import java.io.*

import kotlin.math.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toInt() }

    var i = 0
    var j = N - 1
    var sum = A[i] + A[j]

    while (i < j) {
        val S = A[i] + A[j]

        if (abs(sum) > abs(S)) sum = S

        if (S > 0) j--
        else i++
    }

    println(sum)
}