import java.io.*
import java.util.*

fun get(m: Int) = readLine()!!.trim().split(" ").map { it.toInt() - m }

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>, p: Int, q: Int) {
    val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy({ it.first }))
    val construct = arrayListOf<Pair<Int, Int>>()
    val visited = Array(vertex.size, { false })
    var sum = 0

    pq.offer(Triple(0, 0, 0))

    while (pq.isNotEmpty()) {
        val (C, VP, V) = pq.poll()

        if (visited[V]) continue
        visited[V] = true

        sum += C
        if (C != 0) construct += if (VP < V) Pair(VP, V) else Pair(V, VP)
        vertex[V].forEach { (v, c) -> if (!visited[v]) pq.offer(Triple(c, V, v)) }
    }

    construct.forEach {
        if (p == it.first && q == it.second) {
            println("YES")
            return
        }
    }
    println("NO")
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(get(0)[0]) {
        var (N, M, p, q) = get(0)
        val vertex = Array(N, { arrayListOf<Pair<Int, Int>>() })

        repeat(M) {
            val (u, v, w) = get(1)

            vertex[u] += Pair(v, w + 1)
            vertex[v] += Pair(u, w + 1)
        }

        if (p > q) p = q.also { q = p }
        Prim(vertex, p - 1, q - 1)
    }
}