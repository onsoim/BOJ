import java.io.*
import java.util.*

const val INF = Int.MAX_VALUE

fun get() = readLine()!!.split(" ").map { it.toInt() }

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
    var NMSC = get()

    while (NMSC.sum() != 0) {
        val vertex = Array(NMSC[0], { arrayListOf<Pair<Int, Int>>() })

        repeat(NMSC[1]) {
            val (A, B, X) = get()
            vertex[A - 1] += Pair(B - 1, X)
        }

        println(dijkstra(vertex, NMSC[2] - 1)[NMSC[3] - 1])
        NMSC = get()
    }
}