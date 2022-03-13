import java.io.*
import java.util.*

import kotlin.math.*

const val INF = Int.MAX_VALUE

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun dijkstra(vertex: Array<ArrayList<Int>>, weight: Array<Int>): Int {
    val visited = Array(vertex.size, { false })
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))

    queue.offer(Pair(0, 0))
    var MAX = 0

    do {
        val (t, x) = queue.poll()

        if (!visited[x]) {
            val tmp = t + weight[x]
            MAX = max(tmp, MAX)

            visited[x] = true
            vertex[x].forEach {
                if (!visited[it]) queue.offer(Pair(tmp, it))
            }
        }
        
    } while (queue.isNotEmpty())

    return MAX
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = get()[0]
    val vertex = Array(N, { arrayListOf<Int>() })
    val weight = Array(N, { 0 })
    
    repeat(N) { i ->
        val l = get()

        weight[i] = l[0]
        repeat(l[1]) { j ->
            vertex[i] += l[j + 2] - 1
        }
    }

    println(dijkstra(vertex, weight))
}