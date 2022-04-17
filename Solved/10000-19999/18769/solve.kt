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
    repeat(get()[0]) {
        val (R, C) = get()
        val vertex = Array(R * C, { arrayListOf<Pair<Int, Int>>() })

        repeat(R) { i ->
            get().forEachIndexed { j, v ->
                vertex[i * C + j] += Pair(i * C + j + 1, v)
                vertex[i * C + j + 1] += Pair(i * C + j, v)
            }
        }

        repeat(R - 1) { i ->
            get().forEachIndexed { j, v ->
                vertex[i * C + j] += Pair((i + 1) * C + j, v)
                vertex[(i + 1) * C + j] += Pair(i * C + j, v)
            }
        }

        println(Prim(vertex))
    }
}