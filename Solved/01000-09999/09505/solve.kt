import java.io.*
import java.util.*

const val INF = Int.MAX_VALUE

fun dijkstra2(arr: Array<Array<Int>>, I: Int, J: Int): Int {
    val H = arr.size
    val W = arr[0].size

    val time = Array(H, { Array(W, { INF }) })
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))

    queue.offer(Pair(0, I * 1000 + J))
    time[I][J] = 0

    while (queue.isNotEmpty()) {
        val (c, ij) = queue.poll()
        val i = ij / 1000 % 1000
        val j = ij % 1000

        if (i == 0 || j == 0 || i == H - 1 || j == W - 1) return if (time[i][j] == INF) -1 else time[i][j]

        if (i > 0 && time[i][j] + arr[i - 1][j] < time[i - 1][j]) {
            time[i - 1][j] = time[i][j] + arr[i - 1][j]
            queue.offer(Pair(time[i - 1][j], (i - 1) * 1000 + j))
        }

        if (j > 0 && time[i][j] + arr[i][j - 1] < time[i][j - 1]) {
            time[i][j - 1] = time[i][j] + arr[i][j - 1]
            queue.offer(Pair(time[i][j - 1], i * 1000 + j - 1))
        }

        if (i < H - 1 && time[i][j] + arr[i + 1][j] < time[i + 1][j]) {
            time[i + 1][j] = time[i][j] + arr[i + 1][j]
            queue.offer(Pair(time[i + 1][j], (i + 1) * 1000 + j))
        }

        if (j < W - 1 && time[i][j] + arr[i][j + 1] < time[i][j + 1]) {
            time[i][j + 1] = time[i][j] + arr[i][j + 1]
            queue.offer(Pair(time[i][j + 1], i * 1000 + j + 1))
        }
    }

    return if (time[H - 1][W - 1] == INF) -1 else time[H - 1][W - 1]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine()!!.toInt()) {
        val (K, W, H) = readLine()!!.split(" ").map { it.toInt() }
        val arr = Array(H, { Array(W, { 0 }) })
        val C = mutableMapOf<String, Int>()

        repeat(K) {
            val c = readLine()!!.split(" ")
            C[c[0]] = c[1].toInt()
        }

        var I = -1
        var J = -1
        repeat(H) { i ->
            readLine()!!.forEachIndexed { j, v ->
                if (C[v.toString()] != null) 
                    arr[i][j] = C[v.toString()]!!.toInt()
                else I = i.also { J = j }
            }
        }

        println(dijkstra2(arr, I, J))
    }
}