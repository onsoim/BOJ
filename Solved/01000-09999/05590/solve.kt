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
    val (n, k) = get(0)
    val vertex = Array(n, { arrayListOf<Pair<Int, Int>>() })

    repeat(k) {
        val info = get(1)

        if (info[0] == 0) {
            vertex[info[1]] += Pair(info[2], info[3] + 1)
            vertex[info[2]] += Pair(info[1], info[3] + 1)
        }
        else {
            val fare = dijkstra(vertex, info[1])[info[2]]

            println(if (fare == INF) "-1" else fare)
        }
    }
}