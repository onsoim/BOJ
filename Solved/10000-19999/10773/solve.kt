import java.io.*
import java.util.*

fun get() = readLine()!!.toInt()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sum = Stack<Int>()

    repeat(get()) {
        var n = get()

        if (n == 0) sum.pop() else sum.push(n)
    }

    println(sum.sum())
}