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
    val (C, P, PB, PA1, PA2) = get(1)
    val vertex = Array(P + 1, { arrayListOf<Pair<Int, Int>>() })
    
    repeat(C + 1) {
        val (P1, P2, D) = get(1)

        vertex[P1] += Pair(P2, D + 1)
        vertex[P2] += Pair(P1, D + 1)
    }
    
    val dist = dijkstra(vertex, PA1)

    println(dist[PA2] + min(dist[PB], dijkstra(vertex, PA2)[PB]))
}