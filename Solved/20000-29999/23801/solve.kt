import java.io.*
import java.util.*

import kotlin.math.*

const val INF = Long.MAX_VALUE

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun dijkstra(vertex: Array<ArrayList<Pair<Int, Long>>>, X: Int): Array<Long> {
    val dist    = Array(vertex.size, { INF })
    val queue   = PriorityQueue<Pair<Long, Int>>(compareBy({ it.first }, { it.second }))

    dist[X] = 0L
    queue.offer(Pair(0L, X))

    do {
        val (cost, x) = queue.poll()

        if (dist[x] >= cost) {
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
    val (N, M) = get(0)
    val vertex = Array(N, { arrayListOf<Pair<Int, Long>>() })
    
    repeat(M) {
        val (u, v, w) = get(1)

        vertex[u] += Pair(v, w + 1L)
        vertex[v] += Pair(u, w + 1L)
    }

    val (X, Z) = get(1)

    val distX = dijkstra(vertex, X)
    val distZ = dijkstra(vertex, Z)

    val P = get(0)
    val Y = get(1)

    var min = INF

    Y.forEach {
        val tmpX = distX[it]
        val tmpZ = distZ[it]
        if (tmpX != INF && tmpZ != INF && min > tmpX + tmpZ) min = tmpX + tmpZ
    }
    
    println(if (min == INF) "-1" else min)
}