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
    val (N, M, X, Y) = get()
    val vertex = Array(N, { arrayListOf<Pair<Int, Int>>() })
    
    repeat(M) {
        val (A, B, C) = get()

        vertex[A] += Pair(B, C)
        vertex[B] += Pair(A, C)
    }

    var idx = 0
    var cnt = 0

    dijkstra(vertex, Y).sorted().forEach {
        if (it * 2 > X) {
            println("-1")
            return
        }

        if (it * 2 > cnt) {
            idx++
            cnt = X
        }

        cnt -= it * 2
    }

    println(idx)
}