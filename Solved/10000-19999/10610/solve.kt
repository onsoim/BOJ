import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!
    var sum = 0
    var ZERO = false

    N.forEach {
        if (it == '0') ZERO = true
        sum += it.code - 0x30
    }

    if (ZERO && sum % 3 == 0) println(N.toCharArray().apply { sortDescending() })
    else println("-1")
}