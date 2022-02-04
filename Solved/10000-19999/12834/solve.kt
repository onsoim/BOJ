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
    val (N, V, E) = get(0)
    val vertex = Array(V, { arrayListOf<Pair<Int, Int>>() })
    val (A, B) = get(1)
    val H = get(1)

    repeat(E) {
        val (a, b, l) = get(1)
    
        vertex[a] += Pair(b, l + 1)
        vertex[b] += Pair(a, l + 1)
    }

    val dist1 = dijkstra(vertex, A)
    val dist2 = dijkstra(vertex, B)

    var sum = 0
    H.forEach { sum += dist1[it] + dist2[it] }

    println(sum)
}