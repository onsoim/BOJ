import java.io.*
import java.util.*

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun Prim(vertex: Array<ArrayList<Int>>) {
    val N = vertex.size
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    val visited = Array(N, { false })
    var sum = 0L

    pq.offer(Pair(0, 0))

    while (pq.isNotEmpty()) {
        val (C, V) = pq.poll()

        if (visited[V]) continue
        visited[V] = true

        sum += C
        repeat(N) { i -> if (!visited[i] && V != i) pq.offer(Pair(vertex[V][i], i)) }
    }

    println(sum)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val V = get()[0]
    val vertex = Array(V, { arrayListOf<Int>() })

    repeat(V) { vertex[it] += get() }

    Prim(vertex)
}