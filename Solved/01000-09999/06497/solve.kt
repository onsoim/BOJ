import java.io.*
import java.util.*

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>): Int {
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    val visited = Array(vertex.size, { false })
    var sum = 0

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
    while (true) {
        val (V, E) = get()
        if (V == 0 && E == 0) break
        val vertex = Array(V, { arrayListOf<Pair<Int, Int>>() })
        var sum = 0

        repeat(E) {
            val (A, B, C) = get()

            sum += C
            vertex[A] += Pair(B, C)
            vertex[B] += Pair(A, C)
        }

        println(sum - Prim(vertex))
    }
}