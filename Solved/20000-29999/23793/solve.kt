import java.io.*
import java.util.*

import kotlin.math.*

const val INF = Int.MAX_VALUE

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun dijkstra(vertex: Array<ArrayList<Pair<Int, Int>>>, X: Int): Array<Int> {
    val dist = Array(vertex.size, { INF })
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))

    dist[X] = 0
    queue.offer(Pair(0, X))

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
    val vertex = Array(N, { arrayListOf<Pair<Int, Int>>() })
    val lazy = arrayListOf<Triple<Int, Int, Int>>()
    val lazy2 = arrayListOf<Triple<Int, Int, Int>>()
    
    repeat(M) {
        val (u, v, w) = get(1)

        lazy += Triple(u, v, w + 1)
    }

    val (X, Y, Z) = get(1)

    lazy.forEach { (u, v, w) ->
        if (v != Y) vertex[u] += Pair(v, w)
        else lazy2 += Triple(u, v, w)
    }

    val distXZ = dijkstra(vertex, X)[Z]

    lazy2.forEach { (u, v, w) -> vertex[u] += Pair(v, w) }

    val distXY = dijkstra(vertex, X)[Y]
    val distYZ = dijkstra(vertex, Y)[Z]

    println("${if (distXY == INF || distYZ == INF) "-1" else distXY + distYZ} ${if (distXZ == INF) "-1" else distXZ}")
}