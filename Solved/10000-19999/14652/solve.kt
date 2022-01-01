import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, K) = readLine()!!.split(" ").map { it.toInt() }

    println("${K / M} ${K % M}")
}