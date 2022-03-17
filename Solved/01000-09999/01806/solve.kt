import java.io.*
import java.util.*

const val INF = Int.MAX_VALUE

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, S) = readLine()!!.split(" ").map { it.toInt() }
    val n = readLine()!!.split(" ").map { it.toInt() }

    var len = INF
    var sum = n[0]
    var i   = 0
    var j   = 0

    // for (i in 0..N - 1) { for (j in i + 1..N) if (dp[j] - dp[i] >= S && len > j - i) len = j - i }
    while (i <= j) {
        if (S <= sum) {
            val L = j - i + 1
            if (len > L) len = L

            sum -= n[i++]
        }
        else {
            if (++j == N) break
            sum += n[j]
        }
    }

    println(if (len == INF) 0 else len)
}