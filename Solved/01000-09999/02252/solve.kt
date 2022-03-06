import java.io.*
import java.util.*

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun Topological_sort(vertex: Array<ArrayList<Int>>, inDegree: Array<Int>, N: Int) {
    val visited = Array(N, { true })
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    val T = LinkedList<Int>()

    inDegree.forEachIndexed { i, v ->
        if (v == 0) {
            queue.offer(Pair(1, i))
            visited[i] = false
            T.offer(i + 1)
        }
    }

    while (queue.isNotEmpty()) {
        val (d, i) = queue.poll()

        vertex[i].forEach {
            if (--inDegree[it] == 0 && visited[it]) {
                queue.offer(Pair(d + 1, it))
                visited[it] = false
                T.offer(it + 1)
            }
        }
    }

    println(T.joinToString(" "))
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = get(0)
    val vertex = Array(N, { arrayListOf<Int>() })
    val inDegree = Array(N, { 0 })

    repeat(M) {
        val (A, B) = get(1)
        vertex[A] += B
        inDegree[B]++
    }

    Topological_sort(vertex, inDegree, N)
}