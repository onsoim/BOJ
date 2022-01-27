import java.io.*
import java.util.*

const val INF = Long.MAX_VALUE

fun get() = readLine()!!.split(" ").map{ it.toInt() }.toList()

fun dijkstra(vertex: Array<ArrayList<Pair<Int, Long>>>, X: Int): Array<Long> {
    val dist    = Array(vertex.size, { INF })
    val queue   = PriorityQueue<Pair<Long, Int>>(compareBy({ it.first }, { it.second }))

    dist[X] = 0L
    queue.offer(Pair(0L, X))

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
    println(INF)
    val (N, M) = get()
    val vertex  = Array(N, { arrayListOf<Pair<Int, Long>>() })

    val visible = ArrayList(get())
    visible[N - 1] = 0

    repeat(M) {
        val (a, b, c) = get()
        if (visible[a] == 0 && visible[b] == 0) {
            vertex[a] += Pair(b, c.toLong())
            vertex[b] += Pair(a, c.toLong())
        }
    }

    val time = dijkstra(vertex, 0)[N - 1]
    println(if (time == INF) "-1" else time)
}