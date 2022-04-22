import java.io.*
import java.util.*

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
        vertex[V].forEach { (v, c) -> if (!visited[v]) pq.offer(Pair(c, v)) }
    }

    repeat(N) { if(!visited[it]) return -1 }
    return sum
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    val vertex = Array(N, { arrayListOf<Pair<Int, Int>>() })
    var sum = 0

    repeat(N) { i ->
        readLine()!!.forEachIndexed { j, v ->
            var lan = v.code

            if (lan != 48) {
                if (lan > 96) lan -= 96
                if (lan > 64) lan -= 38

                sum += lan
                if (i != j) {
                    vertex[i] += Pair(j, lan)
                    vertex[j] += Pair(i, lan)
                }
            }
        }
    }

    val prim = Prim(vertex)
    println(if (prim == -1) -1 else sum - prim)
}