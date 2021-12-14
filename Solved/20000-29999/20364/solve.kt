import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (N, Q) = readLine()!!.split(" ").map { it.toInt() }
    val ocs = Array(N + 1, { false })

    repeat(Q) {
        val x = readLine()!!.toInt()
        var tmp = x
        var oc = 0

        while (tmp != 1) {
            if (ocs[tmp]) { oc = tmp }
            tmp /= 2
        }
        ocs[x] = true

        bw.write("${oc}\n")
    }

    bw.flush()
    bw.close()
}