import java.io.*
import java.util.*

fun I  (s: String): Int { return s.toInt() }
fun s2i(s: String): Int { return s.first().code - 65 }

fun Prim(vertex: Array<ArrayList<Pair<Int, Int>>>) {
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

    println(sum)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var n = I(readLine()!!)

    while (n != 0) {
        val vertex = Array(26, { arrayListOf<Pair<Int, Int>>() })

        repeat(n - 1) {
            val l = readLine()!!.split(" ")
            val i = s2i(l[0])

            repeat(l[1].toInt()) { k ->
                val j = s2i(l[k * 2 + 2])

                vertex[i] += Pair(j, I(l[k * 2 + 3]))
                vertex[j] += Pair(i, I(l[k * 2 + 3]))
            }
        }

        Prim(vertex)
        n = I(readLine()!!)
    }
}