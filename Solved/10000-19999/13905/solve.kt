import java.io.*
import java.util.*

fun get(m: Int) = readLine()!!.trim().split(" ").map { it.toInt() - m }

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>, s: Int, e: Int) {
    val pq = PriorityQueue<Pair<Int, Int>>(compareByDescending({ it.first }))
    val visited = Array(vertex.size, { false })
    var max = 1000001

    pq.offer(Pair(1000001, s))

    while (pq.isNotEmpty()) {
        val (C, V) = pq.poll()

        if (visited[V]) continue
        if (max > C) max = C

        if (V == e) {
            println(max)
            return
        }
        visited[V] = true

        vertex[V].forEach { (v, c) -> if (!visited[v]) pq.offer(Pair(c, v)) }
    }

    println(0)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = get(0)
    val vertex = Array(N, { arrayListOf<Pair<Int, Int>>() })
    val (s, e) = get(1)

    repeat(M) {
        val (h1, h2, k) = get(1)

        vertex[h1] += Pair(h2, k + 1)
        vertex[h2] += Pair(h1, k + 1)
    }

    Prim(vertex, s, e)
}