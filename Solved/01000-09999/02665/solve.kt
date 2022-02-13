import java.io.*
import java.util.*

const val INF = Int.MAX_VALUE
const val CI = 1_000_000

fun dijkstra2(arr: Array<Array<Int>>): Int {
    val N = arr.size

    val life = Array(N, { Array(N, { INF }) })
    val queue = PriorityQueue<Int>()

    queue.offer(0)
    life[0][0] = 0

    while (queue.isNotEmpty()) {
        val cij = queue.poll()
        val i = (cij / 1000) % 1000
        val j = cij % 1000

        if (i == N - 1 && j == N - 1) return life[N - 1][N - 1]

        if (i > 0 && life[i][j] + arr[i - 1][j] < life[i - 1][j]) {
            life[i - 1][j] = life[i][j] + arr[i - 1][j]
            queue.offer(life[i - 1][j] * CI + (i - 1) * 1000 + j)
        }

        if (j > 0 && life[i][j] + arr[i][j - 1] < life[i][j - 1]) {
            life[i][j - 1] = life[i][j] + arr[i][j - 1]
            queue.offer(life[i][j - 1] * CI + i * 1000 + j - 1)
        }

        if (i < N - 1 && life[i][j] + arr[i + 1][j] < life[i + 1][j]) {
            life[i + 1][j] = life[i][j] + arr[i + 1][j]
            queue.offer(life[i + 1][j] * CI + (i + 1) * 1000 + j)
        }

        if (j < N - 1 && life[i][j] + arr[i][j + 1] < life[i][j + 1]) {
            life[i][j + 1] = life[i][j] + arr[i][j + 1]
            queue.offer(life[i][j + 1] * CI + i * 1000 + j + 1)
        }
    }

    return life[N - 1][N - 1]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var N = readLine()!!.toInt()
    val arr = Array(N, { Array(N, { 0 })})

    repeat(N) { i ->
        readLine()!!.forEachIndexed { j, v ->
            arr[i][j] = 49 - v.code
        }
    }

    println(dijkstra2(arr))
}