import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (A, I) = readLine()!!.split(" ").map { it.toInt() }
    println( A * (I - 1) + 1)
}