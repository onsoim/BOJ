import java.io.*
import java.util.*

const val INF = Int.MAX_VALUE
const val CI = 1_000_000

fun dijkstra2(arr: Array<Array<Int>>): Int {
    val N = arr.size
    val M = arr[0].size

    val life = Array(N, { Array(M, { INF }) })
    val queue = PriorityQueue<Int>()

    queue.offer(0)
    life[0][0] = 0

    while (queue.isNotEmpty()) {
        val cij = queue.poll()
        val i = (cij / 1000) % 1000
        val j = cij % 1000

        if (i == N - 1 && j == M - 1) return life[N - 1][M - 1]

        if (i > 0 && life[i][j] + arr[i - 1][j] < life[i - 1][j]) {
            life[i - 1][j] = life[i][j] + arr[i - 1][j]
            queue.offer(life[i - 1][j] * CI + (i - 1) * 1000 + j)
        }

        if (j > 0 && life[i][j] + arr[i][j - 1] < life[i][j - 1]) {
            life[i][j - 1] = life[i][j] + arr[i][j - 1]
            queue.offer(life[i][j - 1] * CI + i * 1000 + j - 1)
        }

        if (i < N - 1 && life[i][j] < life[i + 1][j]) {
            life[i + 1][j] = life[i][j] + arr[i + 1][j]
            queue.offer(life[i + 1][j] * CI + (i + 1) * 1000 + j)
        }

        if (j < M - 1 && life[i][j] + arr[i][j + 1] < life[i][j + 1]) {
            life[i][j + 1] = life[i][j] + arr[i][j + 1]
            queue.offer(life[i][j + 1] * CI + i * 1000 + j + 1)
        }
    }

    return life[N - 1][M - 1]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (M, N) = readLine()!!.split(" ").map { it.toInt() }
    val arr = Array(N, { Array(M, { 0 })})

    repeat(N) { i ->
        readLine()!!.forEachIndexed { j, v ->
            arr[i][j] = v.code - 48
        }
    }
    
    println(dijkstra2(arr))
}