import java.io.*
import java.util.*

const val INF = Int.MAX_VALUE

fun get() = readLine()!!.split(" ").map{ it.toInt() }.toList()

fun dijkstra(N: Int, X: Int, vertex: Array<ArrayList<Pair<Int, Int>>>): Array<Int> {
    val dist    = Array(N, { INF })
    val queue   = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))

    dist[X] = 0
    queue.offer(Pair(0, X))

    do {
        val (cost, s) = queue.poll()

        if (dist[s] >= cost) {
            vertex[s].forEach {
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
    val N = get()[0]
    val M = get()[0]

    val vertex  = Array(N, { arrayListOf<Pair<Int, Int>>() })

    repeat(M) {
        val (a, b, c) = get()
        vertex[a - 1] += Pair(b - 1, c)
    }

    val (A, B) = get()
    println(dijkstra(N, A - 1, vertex)[B - 1])
}