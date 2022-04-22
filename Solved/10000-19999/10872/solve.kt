import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var fib = 1

    repeat(readLine()!!.toInt()) { fib *= it + 1 }
    println(fib)
}