import java.io.*
import java.util.*

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>, K: List<Int>) {
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    val visited = Array(vertex.size, { false })
    var sum = 0

    K.forEach { pq.offer(Pair(0, it)) }

    while (pq.isNotEmpty()) {
        val (C, V) = pq.poll()

        if (visited[V]) continue
        visited[V] = true

        sum += C
        vertex[V].forEach { (v, c) -> if (!visited[v]) pq.offer(Pair(c, v)) }
    }

    println(sum)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, K) = get(0)
    val vertex = Array(N, { arrayListOf<Pair<Int, Int>>() })
    val k = get(1)

    repeat(M) {
        val (u, v, w) = get(1)

        vertex[u] += Pair(v, w + 1)
        vertex[v] += Pair(u, w + 1)
    }

    Prim(vertex, k)
}