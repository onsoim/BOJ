import java.io.*
import java.util.*

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>, base: Int) {
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

    println("${base + sum} ${construct.size}")
    construct.forEach { println("${it.first + 1} ${it.second + 1}") }
}

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val vertex = Array(N, { arrayListOf<Pair<Int, Int>>() })
    var base = 0

    repeat(N) { i ->
        repeat(N) { j ->
            var cost = nextInt()

            if (i > j) {
                if (cost < 0) {
                    base += cost * -1
                    cost = 0
                }

                vertex[i] += Pair(j, cost)
                vertex[j] += Pair(i, cost)
            }
        }
    }

    Prim(vertex, base)
}