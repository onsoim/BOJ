import java.io.*
import java.util.*

const val INF = Int.MAX_VALUE

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = get()

    val dp = Array(N, { Array(M, { 0 }) })
    val candy = Array(N, { Array(M, { 0 }) })

    repeat(N) { i ->
        get().forEachIndexed { j, v ->
            var MAX = 0
            if (i > 0 && dp[i - 1][j] > MAX) MAX = dp[i - 1][j]
            if (j > 0 && dp[i][j - 1] > MAX) MAX = dp[i][j - 1]
            dp[i][j] = MAX + v
        }
    }

    println(dp[N - 1][M - 1])
}