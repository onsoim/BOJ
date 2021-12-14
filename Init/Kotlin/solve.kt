import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = readLine()!!.toInt()
    bw.write(N)

    bw.flush()
    bw.close()
}