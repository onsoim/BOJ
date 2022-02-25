import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    val dp = Array(N + 1, { 0 })
    val P = readLine()!!.split(" ").map { it.toInt() }

    repeat(N + 1) { i ->
        P.forEachIndexed { j, v ->
            if (j < i && dp[i - j - 1] + v > dp[i]) {
                dp[i] = dp[i - j - 1] + v
            }
        }
    }

    println(dp[N])
}