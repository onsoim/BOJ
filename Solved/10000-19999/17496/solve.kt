import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, T, C, P) = readLine()!!.split(" ").map { it.toInt() }
    println((N - 1) / T * C * P)
}