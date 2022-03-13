import java.io.*
import java.util.*

import kotlin.math.*

const val INF = 200_000 * 1_000 + 1

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun dijkstra(vertex: Array<ArrayList<Pair<Int, Int>>>, X: Int): Array<Int> {
    val dist = Array(vertex.size, { INF })
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))

    dist[X] = 0
    queue.offer(Pair(0, X))

    do {
        val (cost, x) = queue.poll()

        if (cost <= dist[x]) {
            vertex[x].forEach {
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
    val (N, E) = get(0)
    val vertex = Array(N, { arrayListOf<Pair<Int, Int>>() })

    repeat(E) {
        val (a, b, c) = get(1)
        vertex[a] += Pair(b, c + 1)
        vertex[b] += Pair(a, c + 1)
    }

    val v = get(1)
    val dist1 = dijkstra(vertex, v[0])
    val dist2 = dijkstra(vertex, v[1])

    println(if (dist1[v[1]] == INF || (dist1[0] == INF || dist2[N - 1] == INF) || (dist1[N - 1] == INF || dist2[0] == INF)) "-1" else dist1[v[1]] + min(dist1[0] + dist2[N - 1], dist1[N - 1] + dist2[0]))
}