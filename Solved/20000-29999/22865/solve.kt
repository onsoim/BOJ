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
    val N = get(0)[0]
    val vertex = Array(N, { arrayListOf<Pair<Int, Int>>() })

    val (A, B, C) = get(1)
    
    repeat(get(0)[0]) {
        val (D, E, L) = get(1)

        vertex[D] += Pair(E, L + 1)
        vertex[E] += Pair(D, L + 1)
    }
    
    val distA = dijkstra(vertex, A)
    val distB = dijkstra(vertex, B)
    val distC = dijkstra(vertex, C)

    var idx = -1
    var max = 0

    repeat(N) { i ->
        val tmp = listOf(distA[i], distB[i], distC[i]).minOrNull()!!

        if (tmp > max) {
            idx = i
            max = tmp
        }
    }

    println(idx + 1)
}