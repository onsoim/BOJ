import java.io.*
import java.util.*

import kotlin.math.*

const val INF = Int.MAX_VALUE

fun get() = readLine()!!.split(" ").map{ it.toInt() }

fun dijkstra(vertex: Array<ArrayList<Pair<Int, Int>>>, X: Int): Array<Pair<Int, Int>> {
    val dist = Array(vertex.size, { Pair(INF, INF) })
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))

    dist[X] = Pair(0, 1)
    queue.offer(Pair(0, X))

    do {
        val (cost, x) = queue.poll()

        if (cost <= dist[x].first) {
            vertex[x].forEach {
                val tmp = cost + it.second

                if (dist[it.first].first > tmp) {
                    queue.offer(Pair(tmp, it.first))
                    dist[it.first] = Pair(tmp, dist[x].second + 1)
                }
                else if (dist[it.first].first == tmp) {
                    queue.offer(Pair(tmp, it.first))
                    dist[it.first] = Pair(tmp, min(dist[it.first].second, dist[x].second + 1))
                }
            }
        }
    } while (queue.isNotEmpty())

    return dist
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, R) = get()
    val vertex  = Array(N, { arrayListOf<Pair<Int, Int>>() })

    repeat(R) {
        val (a, b, c, d, e) = get()
        vertex[a - 1] += Pair(b - 1, if (e < 11) c else c + (e - 10) * d)
    }

    val (cost, cnt) = dijkstra(vertex, 0)[N - 1]
    println(if (cost == INF) "It is not a great way." else "${cost} ${cnt}")
}