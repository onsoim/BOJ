import java.io.*
import java.util.*

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>, t: Int) {
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    val visited = Array(vertex.size, { false })
    var sum = 0
    var T = -t

    pq.offer(Pair(0, 0))
    while (pq.isNotEmpty()) {
        val (C, V) = pq.poll()

        if (visited[V]) continue
        visited[V] = true

        sum += C + T
        T += t
        vertex[V].forEach { (v, c) -> if (!visited[v]) pq.offer(Pair(c, v)) }
    }
    sum += t

    println(sum)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, t) = get()
    val vertex = Array(N, { arrayListOf<Pair<Int, Int>>() })

    repeat(M) {
        val (A, B, C) = get()

        vertex[A - 1] += Pair(B - 1, C)
        vertex[B - 1] += Pair(A - 1, C)
    }

    Prim(vertex, t)
}