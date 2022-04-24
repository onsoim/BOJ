import java.io.*
import java.util.*

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>) {
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
        if (C != 0) construct += Pair(VP, V)
        vertex[V].forEach { (v, c) -> if (!visited[v]) pq.offer(Triple(c, V, v)) }
    }

    construct.forEach { println("${it.first + 1} ${it.second + 1}") }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = get()[0]
    val vertex = Array(N, { arrayListOf<Pair<Int, Int>>() })

    repeat(N) { i ->
        get().forEachIndexed { j, c ->

            if (i > j) {
                vertex[i] += Pair(j, c)
                vertex[j] += Pair(i, c)
            }
        }
    }

    Prim(vertex)
}