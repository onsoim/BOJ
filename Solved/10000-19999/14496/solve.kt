import java.io.*
import java.util.*

const val INF = 10001

fun dijkstra(N: Int, X: Int, vertex: Array<ArrayList<Int>>): Array<Int> {
    val dist    = Array(N, { INF })
    val visited = Array(N, { true })
    val queue   = LinkedList<Int>()

    var s = X
    dist[s] = 0
    queue.offer(s)

    do {
        s = queue.poll()
        visited[s] = false

        vertex[s].forEach {
            if (visited[it] && dist[it] > dist[s] + 1) {
                queue.offer(it)
                dist[it] = dist[s] + 1
            }
        }
    } while (queue.isNotEmpty())

    return dist
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() - 1 }
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }

    val vertex  = Array(N, { arrayListOf<Int>() })

    repeat(M) {
        val (A, B) = readLine()!!.split(" ").map { it.toInt() - 1 }
        vertex[A] += B
        vertex[B] += A
    }

    val res = dijkstra(N, a, vertex)[b]
    println(if (res == INF) "-1" else res)
}