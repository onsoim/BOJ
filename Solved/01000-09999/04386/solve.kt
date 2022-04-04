import java.io.*
import java.util.*

import kotlin.math.*

fun Prim(vertex: Array<ArrayList<Pair<Int, Double>>>) {
    val pq = PriorityQueue<Pair<Double, Int>>(compareBy({ it.first }))
    val visited = Array(vertex.size, { false })
    var sum = 0.0

    pq.offer(Pair(0.0, 0))

    while (pq.isNotEmpty()) {
        val (C, V) = pq.poll()

        if (visited[V]) continue
        visited[V] = true

        sum += C
        vertex[V].forEach { (v, c) -> if (!visited[v]) pq.offer(Pair(c, v)) }
    }

    println((sum * 100).toInt().toDouble() / 100)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    val vertex = Array(N, { arrayListOf<Pair<Int, Double>>() })

    val star = arrayListOf<Pair<Double, Double>>()

    repeat(N) {
        val (X, Y) = readLine()!!.split(" ").map { it.toDouble() }
        star += Pair(X, Y)
    }

    repeat(N) { i ->
        repeat(N) { j ->
            if (i != j) {
                vertex[i].add(Pair(j, sqrt(((star[i].first - star[j].first) * (star[i].first - star[j].first) + (star[i].second - star[j].second) * (star[i].second - star[j].second)).toDouble())))
            }
        }
    }

    Prim(vertex)
}