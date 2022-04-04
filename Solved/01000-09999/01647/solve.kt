import java.io.*
import java.util.*

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>) {
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    val visited = Array(vertex.size, { false })
    var sum = 0
    var max = 0

    pq.offer(Pair(0, 0))

    while (pq.isNotEmpty()) {
        val (C, V) = pq.poll()

        if (visited[V]) continue
        if (C > max) max = C
        visited[V] = true

        sum += C
        vertex[V].forEach { (v, c) -> if (!visited[v]) pq.offer(Pair(c, v)) }
    }

    println(sum - max)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (V, E) = get()
    val vertex = Array(V, { arrayListOf<Pair<Int, Int>>() })

    repeat(E) {
        val (A, B, C) = get()

        vertex[A - 1] += Pair(B - 1, C)
        vertex[B - 1] += Pair(A - 1, C)
    }

    Prim(vertex)
}