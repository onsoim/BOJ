import java.io.*
import java.util.*

lateinit var gender: List<String>

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>): Int {
    val N = vertex.size
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    val visited = Array(N, { false })
    var sum = 0

    pq.offer(Pair(0, 0))

    while (pq.isNotEmpty()) {
        val (C, V) = pq.poll()

        if (visited[V]) continue
        visited[V] = true

        sum += C
        vertex[V].forEach { (v, c) -> if (!visited[v] && gender[V] != gender[v]) pq.offer(Pair(c, v)) }
    }

    repeat(N) { if(!visited[it]) return -1 }
    return sum
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (V, E) = get()
    val vertex = Array(V, { arrayListOf<Pair<Int, Int>>() })
    gender = readLine()!!.split(" ")

    repeat(E) {
        val (A, B, C) = readLine()!!.split(" ").map { it.toInt() }

        vertex[A - 1] += Pair(B - 1, C)
        vertex[B - 1] += Pair(A - 1, C)
    }

    println(Prim(vertex))
}