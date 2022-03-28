import java.io.*

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (L, P) = get()

    val people = arrayListOf<Int>()
    get().forEach { people += it - L * P }

    println(people.joinToString(" "))
}