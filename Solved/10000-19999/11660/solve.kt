import java.io.*

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = get(0)
    val dp = Array(N, { Array(N, { 0 }) })

    repeat(N) { i ->
        get(0).forEachIndexed { j, v ->
            var tmp = v

            if (i > 0) tmp += dp[i - 1][j]
            if (j > 0) tmp += dp[i][j - 1]
            if (i > 0 && j > 0) tmp -= dp[i - 1][j - 1]

            dp[i][j] = tmp
        }
    }

    repeat(M) {
        val (x1, y1, x2, y2) = get(1)

        var flagA = false
        var flagB = false

        var tmp = dp[x2][y2]

        if (y1 > 0) {
            tmp -= dp[x2][y1 - 1]
            flagA = true
        }

        if (x1 > 0) {
            tmp -= dp[x1 - 1][y2]
            flagB = true
        }

        if (flagA && flagB) tmp += dp[x1 - 1][y1 - 1]

        println(tmp)
    }
}