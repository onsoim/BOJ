import java.io.*
import java.util.*

import kotlin.math.*

const val INF = Int.MAX_VALUE
const val CI = 1_000_000

fun dijkstra2(arr: Array<Array<Int>>): Int {
    val M = arr.size
    val N = arr[0].size

    val ladder = Array(M, { Array(N, { INF }) })
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))

    queue.offer(Pair(0, 0))
    ladder[0][0] = 0

    while (queue.isNotEmpty()) {
        val (c, ij) = queue.poll()
        val i = ij / 1000 % 1000
        val j = ij % 1000

        if (i == M - 1 && j == N - 1) return ladder[M - 1][N - 1]

        if (i > 0) {
            val tmp = max(
                ladder[i][j],
                if (arr[i - 1][j] > arr[i][j]) arr[i - 1][j] - arr[i][j] else 0
            )
            if (tmp < ladder[i - 1][j]) {
                ladder[i - 1][j] = tmp
                queue.offer(Pair(tmp, (i - 1) * 1000 + j))
            }
        }

        if (j > 0) {
            val tmp = max(
                ladder[i][j],
                if (arr[i][j - 1] > arr[i][j]) arr[i][j - 1] - arr[i][j] else 0
            )
            if (tmp < ladder[i][j - 1]) {
                ladder[i][j - 1] = tmp
                queue.offer(Pair(tmp, i * 1000 + j - 1))
            }
        }

        if (i < M - 1) {
            val tmp = max(
                ladder[i][j],
                if (arr[i + 1][j] > arr[i][j]) arr[i + 1][j] - arr[i][j] else 0
            )
            if (tmp < ladder[i + 1][j]) {
                ladder[i + 1][j] = tmp
                queue.offer(Pair(tmp, (i + 1) * 1000 + j))
            }
        }

        if (j < N - 1) {
            val tmp = max(
                ladder[i][j],
                if (arr[i][j + 1] > arr[i][j]) arr[i][j + 1] - arr[i][j] else 0
            )
            if (tmp < ladder[i][j + 1]) {
                ladder[i][j + 1] = tmp
                queue.offer(Pair(tmp, i * 1000 + j + 1))
            }
        }
    }

    return ladder[M - 1][N - 1]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (M, N) = readLine()!!.split(" ").map { it.toInt() }
    val arr = Array(M, { Array(N, { 0 })})

    repeat(M) { i ->
        readLine()!!.split(" ").map { it.toInt() }.forEachIndexed { j, v ->
            arr[i][j] = v
        }
    }
    
    println(dijkstra2(arr))
}