import java.io.*
import java.util.*

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>) {
    var N = vertex.size
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    val visited = Array(N, { false })
    val line = arrayListOf<Int>()

    pq.offer(Pair(0, 0))

    while (pq.isNotEmpty()) {
        val (C, V) = pq.poll().toList().map { it.toInt() }

        if (visited[V]) continue
        visited[V] = true
        N--

        if (C != 0) line += C
        vertex[V].forEach { (v, c) -> if (!visited[v.toInt()]) pq.offer(Pair(c, v)) }
    }

    println(line.sorted()[line.size / 2])
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (n, m) = get(0)

    while (n != 0 && m != 0) {
        val vertex = Array(n, { arrayListOf<Pair<Int, Int>>() })

        repeat(m) {
            val (s, t, c) = get(1)

            vertex[s] += Pair(t, c + 1)
            vertex[t] += Pair(s, c + 1)
        }

        Prim(vertex)

        val (N, M) = get(0)
        n = N
        m = M
    }
}