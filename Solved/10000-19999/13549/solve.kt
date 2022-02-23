import java.io.*
import java.util.*

const val INF = Int.MAX_VALUE
const val MAX = 100001

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val dp = Array(MAX, { INF })
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    
    dp[N] = 0
    queue.offer(Pair(0, N))

    while (true) {
        val (t, X) = queue.poll()

        if (X == K) break

        var tmp = t

        if (X * 2 < MAX && tmp < dp[X * 2]) {
            dp[X * 2] = tmp
            queue.offer(Pair(tmp, X * 2))
        }

        tmp++
        if (X > 0 && tmp < dp[X - 1]) {
            dp[X - 1] = tmp
            queue.offer(Pair(tmp, X - 1))
        }

        if (X < MAX - 1 && tmp < dp[X + 1]) {
            dp[X + 1] = tmp
            queue.offer(Pair(tmp, X + 1))
        }
    }

    println(dp[K])
}