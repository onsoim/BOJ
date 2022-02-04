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
    val (n, m) = get(0)

    val vertex = Array(n, { arrayListOf<Pair<Int, Int>>() })

    repeat(m) {
        val (a, b, c) = get(0)

        vertex[a - 1] += Pair(b - 1, c)
        vertex[b - 1] += Pair(a - 1, c)
    }

    val (p, q) = get(0)
    val house = get(1)
    val convinient = get(1)

    var idx = -1
    var min = INF

    convinient.forEach {
        val dist = dijkstra(vertex, it)

        house.forEach {
            if (dist[it] < min) {
                min = dist[it]
                idx = it + 1
            }
        }
    }

    println(idx)
}