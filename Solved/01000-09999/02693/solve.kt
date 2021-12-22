import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine()!!.toInt()) { println(readLine()!!.split(" ").map { it.toInt() }.sorted()[7]) }
}