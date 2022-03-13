import java.io.*
import java.util.*

const val INF = Int.MAX_VALUE

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val dp = Array(k + 1, { INF })
    val P = Array(n, { 0 })

    repeat(n) { i ->
        P[i] = readLine()!!.toInt()
    }

    dp[0] = 0
    repeat(k + 1) { i ->
        P.forEach {
            if (it <= i && dp[i - it] != INF && dp[i - it] + 1 < dp[i])  dp[i] = dp[i - it] + 1
        }
    }

    println(if (dp[k] == INF) -1 else dp[k])
}