import java.io.*
import java.util.*

const val INF = Int.MAX_VALUE

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    val dp = Array(N + 1, { INF })
    val arr = Array(N + 1, { arrayListOf<Int>() })
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))

    queue.offer(Pair(0, N))
    dp[N] = 0
    arr[N].add(N)

    while (true) {
        val (t, X) = queue.poll()

        if (X == 1) break

        var tmp = t + 1

        if (X % 3 == 0 && dp[X / 3] > tmp) {
            dp[X / 3] = tmp

            arr[X / 3].clear()
            arr[X].forEach {
                arr[X / 3].add(it)
            }
            arr[X / 3].add(X / 3)

            queue.offer(Pair(tmp, X / 3))
        }

        if (X % 2 == 0 && dp[X / 2] > tmp) {
            dp[X / 2] = tmp

            arr[X / 2].clear()
            arr[X].forEach {
                arr[X / 2].add(it)
            }
            arr[X / 2].add(X / 2)

            queue.offer(Pair(tmp, X / 2))
        }

        if (dp[X - 1] > tmp) {
            dp[X - 1] = tmp

            arr[X - 1].clear()
            arr[X].forEach {
                arr[X - 1].add(it)
            }
            arr[X - 1].add(X - 1)

            queue.offer(Pair(tmp, X - 1))
        }
    }

    println(dp[1])
    println(arr[1].joinToString(" "))
}