import java.io.*
import java.util.*

import kotlin.math.*

const val INF = Int.MAX_VALUE
const val CI = 1_000_000

fun dijkstra2(arr: Array<Array<Int>>): Int {
    val N = arr.size

    val life = Array(N, { Array(N, { INF }) })
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))

    queue.offer(Pair(0, 0))
    life[0][0] = 0

    while (queue.isNotEmpty()) {
        val (D, ij) = queue.poll()
        val i = ij / 1000 % 1000
        val j = ij % 1000

        if (i == N - 1 && j == N - 1) return life[N - 1][N - 1]

        if (i > 0) {
            var tmp = abs(arr[i - 1][j] - arr[i][j])
            tmp = max(tmp, life[i][j])

            if (tmp < life[i - 1][j]) {
                life[i - 1][j] = tmp
                queue.offer(Pair(life[i - 1][j], (i - 1) * 1000 + j))
            }
        }

        if (j > 0) {
            var tmp = abs(arr[i][j - 1] - arr[i][j])
            tmp = max(tmp, life[i][j])

            if (tmp < life[i][j - 1]) {
                life[i][j - 1] = tmp
                queue.offer(Pair(life[i][j - 1], i * 1000 + j - 1))
            }
        }

        if (i < N - 1) {
            var tmp = abs(arr[i + 1][j] - arr[i][j])
            tmp = max(tmp, life[i][j])

            if (tmp < life[i + 1][j]) {
                life[i + 1][j] = tmp
                queue.offer(Pair(life[i + 1][j], (i + 1) * 1000 + j))
            }
        }

        if (j < N - 1) {
            var tmp = abs(arr[i][j + 1] - arr[i][j])
            tmp = max(tmp, life[i][j])

            if (tmp < life[i][j + 1]) {
                life[i][j + 1] = tmp
                queue.offer(Pair(life[i][j + 1], i * 1000 + j + 1))
            }
        }
    }

    return life[N - 1][N - 1]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    val arr = Array(N, { Array(N, { 0 })})

    repeat(N) { i ->
        readLine()!!.split(" ").map { it.toInt() }.forEachIndexed { j, v ->
            arr[i][j] = v
        }
    }

    println(dijkstra2(arr))
}