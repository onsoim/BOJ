import java.io.*
import java.util.*

const val INF = 300_000 * 10 + 1

fun get() = readLine()!!.split(" ").map{ it.toInt() }.toList()

fun dijkstra(N: Int, X: Int, vertex: Array<ArrayList<Pair<Int, Int>>>): Array<Int> {
    val dist    = Array(N, { INF })
    val queue   = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))

    dist[X] = 0
    queue.offer(Pair(0, X))

    do {
        val (cost, s) = queue.poll()

        if (dist[s] >= cost) {
            vertex[s].forEach {
                val tmp = cost + it.second
                if (dist[it.first] > tmp) {
                    queue.offer(Pair(tmp, it.first))
                    dist[it.first] = tmp
                }
            }
        }
    } while (queue.isNotEmpty())

    return dist
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (V, E) = get()
    val vertex  = Array(V, { arrayListOf<Pair<Int, Int>>() })

    val K = get()[0] - 1

    repeat(E) {
        val (a, b, c) = get()
        vertex[a - 1] += Pair(b - 1, c)
    }

    dijkstra(V, K, vertex).forEach { println(if (it == INF) "INF" else it) }
}