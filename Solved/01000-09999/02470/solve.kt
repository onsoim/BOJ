import java.io.*
import java.util.*

import kotlin.math.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()

    val n = readLine()!!.split(" ").map { it.toInt() }.sorted()

    var i = 0
    var j = N - 1

    var MAX = 2_000_000_000
    var I = n[i]
    var J = n[j]

    while (i != j) {
        val tmp = n[i] + n[j]
        val aTmp = abs(tmp)

        if (MAX > aTmp) {
            MAX = aTmp
            I = n[i]
            J = n[j]
        }

        if (tmp > 0) j--
        else i++
    }

    println("${I} ${J}")
}