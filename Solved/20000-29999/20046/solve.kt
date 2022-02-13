import java.io.*
import java.util.*

const val INF = Int.MAX_VALUE
const val CI = 1_000_000

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun dijkstra2(arr: Array<Array<Int>>): Int {
    val M = arr.size
    val N = arr[0].size

    val life = Array(M, { Array(N, { INF }) })
    val queue = PriorityQueue<Int>()

    queue.offer(0)
    if (arr[0][0] > -1) life[0][0] = arr[0][0]
    else return -1

    while (queue.isNotEmpty()) {
        val cij = queue.poll()
        val i = (cij / 1000) % 1000
        val j = cij % 1000

        if (i == M - 1 && j == N - 1) return if (life[M - 1][N - 1] == INF) -1 else life[M - 1][N - 1]

        if (i > 0 && arr[i - 1][j] > -1 && life[i][j] + arr[i - 1][j] < life[i - 1][j]) {
            life[i - 1][j] = life[i][j] + arr[i - 1][j]
            queue.offer(life[i - 1][j] * CI + (i - 1) * 1000 + j)
        }

        if (j > 0 && arr[i][j - 1] > -1 && life[i][j] + arr[i][j - 1] < life[i][j - 1]) {
            life[i][j - 1] = life[i][j] + arr[i][j - 1]
            queue.offer(life[i][j - 1] * CI + i * 1000 + j - 1)
        }

        if (i < M - 1 && arr[i + 1][j] > -1 && life[i][j] + arr[i + 1][j] < life[i + 1][j]) {
            life[i + 1][j] = life[i][j] + arr[i + 1][j]
            queue.offer(life[i + 1][j] * CI + (i + 1) * 1000 + j)
        }

        if (j < N - 1 && arr[i][j + 1] > -1 && life[i][j] + arr[i][j + 1] < life[i][j + 1]) {
            life[i][j + 1] = life[i][j] + arr[i][j + 1]
            queue.offer(life[i][j + 1] * CI + i * 1000 + j + 1)
        }
    }

    return if (life[M - 1][N - 1] == INF) -1 else life[M - 1][N - 1]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (m, n) = get()
    val arr = Array(m, { Array(n, { 0 })})

    repeat(m) { i ->
        get().forEachIndexed { j, v ->
            arr[i][j] = v
        }
    }

    println(dijkstra2(arr))
}