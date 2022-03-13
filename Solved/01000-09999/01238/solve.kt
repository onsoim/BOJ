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
    val (N, M, X) = get(0)
    val vertex = Array(N, { arrayListOf<Pair<Int, Int>>() })
    val vertexR = Array(N, { arrayListOf<Pair<Int, Int>>() })

    repeat(M) {
        val (A, B, T) = get(1)
        vertex[A] += Pair(B, T + 1)
        vertexR[B] += Pair(A, T + 1)
    }

    val dist = Array(N, { 0 })
    dijkstra(vertex, X - 1).forEachIndexed { i, v -> dist[i] += v }
    dijkstra(vertexR, X - 1).forEachIndexed { i, v -> dist[i] += v }

    println(dist.maxOrNull()!!)
}