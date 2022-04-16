import java.io.*
import java.util.*

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>) {
    var pq = PriorityQueue<Pair<Int, Int>>(compareByDescending({ it.first }))
    var visited = Array(vertex.size, { false })
    var max = 0

    pq.offer(Pair(0, 0))

    while (pq.isNotEmpty()) {
        val (C, V) = pq.poll()

        if (visited[V]) continue
        visited[V] = true

        max += C
        vertex[V].forEach { if (!visited[it.second]) pq.offer(it) }
    }

    pq = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    visited = Array(vertex.size, { false })
    var min = 0

    pq.offer(Pair(0, 0))

    while (pq.isNotEmpty()) {
        val (C, V) = pq.poll()

        if (visited[V]) continue
        visited[V] = true

        min += C
        vertex[V].forEach { if (!visited[it.second]) pq.offer(it) }
    }

    println(max * max - min * min)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = get()
    val vertex = Array(N + 1, { arrayListOf<Pair<Int, Int>>() })

    repeat(M + 1) {
        var (a, b, c) = get()

        c = c.xor(1)
        vertex[a] += Pair(c, b)
        vertex[b] += Pair(c, a)
    }

    Prim(vertex)
}