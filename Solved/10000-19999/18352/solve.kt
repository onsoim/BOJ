import java.io.*
import java.util.*

import kotlin.math.*

fun dijkstra(N: Int, X: Int, vertex: Array<ArrayList<Int>>): Array<Int> {
    val INF = 1_000_001

    val dist    = Array(N, { INF })
    val visited = Array(N, { true })

    val queue = LinkedList<Int>()

    var s = X
    dist[s] = 0
    queue.offer(s)

    do {
        s = queue.poll()
        visited[s] = false

        vertex[s].forEach {
            if (visited[it]) {
                queue.offer(it)
                dist[it] = min(dist[it], dist[s] + 1)
            }
        }
    } while (queue.isNotEmpty())

    return dist
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, K, X) = readLine()!!.split(" ").map { it.toInt() }

    val vertex  = Array(N, { arrayListOf<Int>() })

    repeat(M) {
        val (A, B) = readLine()!!.split(" ").map { it.toInt() - 1 }
        vertex[A] += B
    }

    // val list = dijkstra(N, X - 1, vertex).filterIndexed { index, s -> s == K }
    val list = arrayListOf<Int>()
    dijkstra(N, X - 1, vertex).forEachIndexed { i, v ->
        if (v == K) list.add(i + 1)
    }
    println(if (list.isNotEmpty()) list.joinToString("\n") else "-1")
}