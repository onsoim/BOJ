import java.io.*
import java.util.*

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>): Int {
    val N = vertex.size
    val pq = PriorityQueue<Pair<Int, Int>>(compareByDescending({ it.first }))
    val visited = Array(N, { false })
    var sum = 0

    pq.offer(Pair(0, 0))

    while (pq.isNotEmpty()) {
        val (C, V) = pq.poll()

        if (visited[V]) continue
        visited[V] = true

        sum += C
        vertex[V].forEach { (v, c) -> if (!visited[v]) pq.offer(Pair(c, v)) }
    }

    repeat(N) { if(!visited[it]) return -1 }
    return sum
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = get(0)
    val vertex = Array(N, { arrayListOf<Pair<Int, Int>>() })
    var sum = M

    repeat(M) {
        val (a, b, c) = get(1)

        sum += c
        vertex[a] += Pair(b, c + 1)
        vertex[b] += Pair(a, c + 1)
    }

    println(Prim(vertex))
}