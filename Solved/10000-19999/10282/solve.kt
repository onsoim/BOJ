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
    repeat(get(0)[0]) {
        val (n, d, c) = get(0)
        val vertex = Array(n, { arrayListOf<Pair<Int, Int>>() })

        repeat(d) {
            val (a, b, s) = get(1)
            vertex[b] += Pair(a, s + 1)
        }

        var cnt = 0
        var max = -1

        dijkstra(vertex, c - 1).forEach {
            if (it != INF) {
                cnt++
                if (it > max) max = it
            }
        }

        println("${cnt} ${max}")
    }
}