import java.io.*
import java.util.*

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
        if (VP != V) construct += Pair(VP, V)
        vertex[V].forEach { (v, c) -> if (!visited[v]) pq.offer(Triple(c, V, v)) }
    }

    println(sum)
    construct.forEach { println("${it.first} ${it.second}") }
}

fun main() = with(Scanner(System.`in`)) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val vertex = Array(n, { arrayListOf<Pair<Int, Int>>() })
    val DNA = arrayListOf<String>()

    repeat(n) { i ->
        val dna = readLine()!!

        DNA.forEachIndexed { j, d ->
            var cnt = 0

            repeat(k) { if (d[it] != dna[it]) cnt++ }

            vertex[i] += Pair(j, cnt)
            vertex[j] += Pair(i, cnt)
        }
        DNA += dna
    }

    Prim(vertex)
}