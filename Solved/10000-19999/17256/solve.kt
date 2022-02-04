import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val a = readLine()!!.split(" ").map { it.toInt() }
    val c = readLine()!!.split(" ").map { it.toInt() }

    println("${c[0] - a[2]} ${c[1] / a[1]} ${c[2] - a[0]}")
}