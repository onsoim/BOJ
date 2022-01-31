import java.io.*
import java.util.*

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
    val (V, E, P) = get(0)
    val vertex = Array(V, { arrayListOf<Pair<Int, Int>>() })

    repeat(E) {
        val (a, b, c) = get(1)

        vertex[a] += Pair(b, c + 1)
        vertex[b] += Pair(a, c + 1)
    }

    val dist = dijkstra(vertex, 0)

    println(if (dist[V - 1] == dist[P - 1] + dijkstra(vertex, P - 1)[V - 1]) "SAVE HIM" else "GOOD BYE")
}