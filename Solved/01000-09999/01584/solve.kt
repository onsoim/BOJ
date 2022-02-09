import java.io.*
import java.util.*

import kotlin.math.*

fun get() = readLine()!!.split(" ").map { it.toInt() }

const val INF = Int.MAX_VALUE
const val N = 500
const val CI = 1_000_000

fun dijkstra2(arr: Array<Array<Int>>): Int {
    val life = Array(N + 1, { Array(N + 1, { INF }) })
    val queue = PriorityQueue<Int>()

    queue.offer(0)
    life[0][0] = 0

    while (queue.isNotEmpty()) {
        val lij = queue.poll()
        val c = lij / CI
        val i = (lij / 1000) % 1000
        val j = lij % 1000

        if (i == N && j == N) return life[N][N]

        if (i > 0 && arr[i - 1][j] < 2 && life[i][j] + arr[i - 1][j] < life[i - 1][j]) {
            life[i - 1][j] = life[i][j] + arr[i - 1][j]
            queue.offer(life[i - 1][j] * CI + (i - 1) * 1000 + j)
        }

        if (j > 0 && arr[i][j - 1] < 2 && life[i][j] + arr[i][j - 1] < life[i][j - 1]) {
            life[i][j - 1] = life[i][j] + arr[i][j - 1]
            queue.offer(life[i][j - 1] * CI + i * 1000 + j - 1)
        }

        if (i < N && arr[i + 1][j] < 2 && life[i][j] < life[i + 1][j]) {
            life[i + 1][j] = life[i][j] + arr[i + 1][j]
            queue.offer(life[i + 1][j] * CI + (i + 1) * 1000 + j)
        }

        if (j < N && arr[i][j + 1] < 2 && life[i][j] + arr[i][j + 1] < life[i][j + 1]) {
            life[i][j + 1] = life[i][j] + arr[i][j + 1]
            queue.offer(life[i][j + 1] * CI + i * 1000 + j + 1)
        }
    }

    return life[N][N]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val arr = Array(N + 1, { Array(N + 1, { 0 }) })

    repeat(2) { k ->
        repeat(get()[0]) {
            val (X1, Y1, X2, Y2) = get()

            for (i in min(X1, X2)..max(X1, X2))
                for (j in min(Y1, Y2)..max(Y1, Y2))
                    arr[i][j] = k + 1
        }
    }

    val L = dijkstra2(arr)

    println(if (L == INF) -1 else L)
}