import java.io.*
import java.util.*

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun Prim(vertex: Array<Array<Int>>, m: Int): Array<Int> {
    val N = vertex.size
    var M = m - N + 1

    val pq = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))
    val visited = Array(N, { false })

    val construct = Array(N, { 0 })
    val tmp = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))

    pq.offer(Pair(0, 0))

    while (pq.isNotEmpty()) {
        val (VP, V) = pq.poll()

        if (visited[VP] && visited[V]) {
            tmp.offer(Pair(VP, V))
            continue
        }

        if (VP != V) {
            construct[VP]++
            construct[V]++
        }

        val v = if (!visited[V]) V else VP

        visited[v] = true
        repeat(N) { if (vertex[v][it] != 0 && !visited[it]) pq.offer(if (v < it) Pair(v, it) else Pair(it, v)) }
    }

    repeat(N) { if(!visited[it]) return arrayOf(-1) }

    repeat(M) {
        if (tmp.isEmpty()) return arrayOf(-1) 

        val (VP, V) = tmp.poll()

        if (VP != V) {
            construct[VP]++
            construct[V]++
        }
    }

    return construct
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val vertex = Array(N, { Array(N, { 0 }) })

    repeat(N) { i -> readLine()!!.forEachIndexed { j, v -> if (v == 'Y') vertex[i][j] = 1 } }

    println(Prim(vertex, M).joinToString(" "))
}