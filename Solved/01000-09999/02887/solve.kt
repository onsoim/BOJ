import java.io.*
import java.util.*
import kotlin.math.*

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>) {
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    val visited = Array(vertex.size, { false })
    var N = vertex.size
    var sum = 0

    pq.offer(Pair(0, 0))

    while (pq.isNotEmpty()) {
        val (C, V) = pq.poll()

        if (visited[V]) continue
        visited[V] = true
        if (N-- == 0) break

        sum += C
        vertex[V].forEach { (v, c) -> if (!visited[v]) pq.offer(Pair(c, v)) }
    }

    println(sum)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()

    val X = arrayListOf<Pair<Int, Int>>()
    val Y = arrayListOf<Pair<Int, Int>>()
    val Z = arrayListOf<Pair<Int, Int>>()

    val vertex = Array(N, { arrayListOf<Pair<Int, Int>>() })

    repeat(N) { i ->
        val (x, y, z) = readLine()!!.split(" ").map { it.toInt() }

        X.add(Pair(x, i))
        Y.add(Pair(y, i))
        Z.add(Pair(z, i))
    }

    X.sortBy { it.first }
    Y.sortBy { it.first }
    Z.sortBy { it.first }

    repeat(N - 1) { i ->
        var d = X[i + 1].first - X[i].first
        vertex[X[i].second] += Pair(X[i + 1].second, d)
        vertex[X[i + 1].second] += Pair(X[i].second, d)

        d = Y[i + 1].first - Y[i].first
        vertex[Y[i].second] += Pair(Y[i + 1].second, d)
        vertex[Y[i + 1].second] += Pair(Y[i].second, d)

        d = Z[i + 1].first - Z[i].first
        vertex[Z[i].second] += Pair(Z[i + 1].second, d)
        vertex[Z[i + 1].second] += Pair(Z[i].second, d)
    }

    Prim(vertex)
}