import java.io.*
import java.util.*

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(get()[0]) {
        var ONE = 0
        get().forEach { if (it % 2 == 1) ONE++ }
        bw.write(if (ONE < 2) "R\n" else "B\n")
    }

    bw.flush()
    bw.close()
}