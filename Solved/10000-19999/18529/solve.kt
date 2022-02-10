import java.io.*
import java.util.*

import kotlin.math.*

const val INF = Int.MAX_VALUE

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun dijkstra(vertex: Array<ArrayList<Pair<Int, Int>>>, n: Int): Int {
    val k = vertex.size
    val dist = Array(n, { Array(n, { INF })})
    val queue = PriorityQueue<Triple<Int, Int, Int>>(compareBy({ it.first }))

    vertex[0].forEach { (i, j) -> 
        dist[i][j] = 0
        queue.offer(Triple(0, 0, i * 100 + j))
    }

    while (queue.isNotEmpty()) {
        val (c, idx, ij) = queue.poll()
        var i = ij / 100
        var j = ij % 100

        if (idx == k - 1) return if (dist[i][j] == INF) -1 else dist[i][j]

        vertex[idx + 1].forEach { (ni, nj) ->
            val tmp = c + abs(i - ni) + abs(j - nj)
            if (dist[ni][nj] > tmp) {
                dist[ni][nj] = tmp
                queue.offer(Triple(tmp, idx + 1, ni * 100 + nj))
            }
        }
    }

    return -1
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = get(0)
    val vertex = Array(k, { arrayListOf<Pair<Int, Int>>() })

    repeat(n) { i ->
        get(1).forEachIndexed { j, v ->
            vertex[v] += Pair(i, j)
        }
    }

    println(dijkstra(vertex, n))
}