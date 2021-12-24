import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    println((readLine()!!.toInt() - 1) / 5 + 1)
}