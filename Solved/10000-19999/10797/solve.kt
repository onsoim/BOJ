import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val end = readLine()!!.toInt()
    var cnt = 0

    readLine()!!.split(" ").map {
        it.toInt()
    }.forEach { if (it % 10 == end) cnt++ }

    println(cnt)
}