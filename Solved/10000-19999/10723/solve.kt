import java.io.*
import java.util.*

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>): Long {
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    val visited = Array(vertex.size, { false })
    var sum = 0L

    pq.offer(Pair(0, 0))

    while (pq.isNotEmpty()) {
        val (C, V) = pq.poll()

        if (visited[V]) continue
        visited[V] = true

        sum += C
        vertex[V].forEach { (v, c) -> if (!visited[v]) pq.offer(Pair(c, v)) }
    }

    return sum
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(get()[0]) {
        val (n, m) = get()
        val vertex = Array(n, { arrayListOf<Pair<Int, Int>>() })
        var res = 0L

        repeat(n - 1) { i ->
            val (u, c) = get()

            vertex[i + 1] += Pair(u, c)
            vertex[u] += Pair(i + 1, c)
        }

        repeat(m) {
            val (u, v, c) = get()

            if (u != v) {
                vertex[u] += Pair(v, c)
                vertex[v] += Pair(u, c)
            }

            res = res.xor(Prim(vertex))
        }

        println(res)
    }
}