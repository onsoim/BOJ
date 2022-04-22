import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    while (true) {
        val l = readLine()!!.split(" ").map { it.toInt() }.sorted()
        if (l[0] == 0 && l[1] == 0 && l[2] == 0) break

        println(if (l[0] * l[0] + l[1] * l[1] == l[2] * l[2]) "right" else "wrong")
    }
}