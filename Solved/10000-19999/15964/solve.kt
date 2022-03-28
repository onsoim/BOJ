import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (A, B) = readLine()!!.split(" ").map { it.toLong() }
    println((A+B)*(A-B))
}