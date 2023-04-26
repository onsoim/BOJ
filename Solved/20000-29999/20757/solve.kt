import java.io.*
import java.util.*

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>) {
    val N = vertex.size
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    val visited = Array(N, { false })
    var sum = 0

    repeat(N) { i ->
        if (!visited[i]) {
            pq.offer(Pair(0, i))

            while (pq.isNotEmpty()) {
                val (C, V) = pq.poll()

                if (visited[V]) continue
                visited[V] = true

                sum += C
                vertex[V].forEach { (v, c) -> if (!visited[v]) pq.offer(Pair(c, v)) }
            }
        }
    }

    println(sum)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(get()[0]) {
        val N = get()[0]
        val vertex = Array(N, { arrayListOf<Pair<Int, Int>>() })

        repeat(N) { i ->
            get().forEachIndexed { j, v ->
                if (i < j && v == 1) {
                    vertex[i] += Pair(j, 1)
                    vertex[j] += Pair(i, 1)
                }
            }
        }

        Prim(vertex)
    }
}