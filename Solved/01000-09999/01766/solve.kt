import java.io.*
import java.util.*

lateinit var vertex: Array<ArrayList<Int>>
lateinit var vertexR: Array<ArrayList<Int>>
lateinit var inDegree: Array<Int>

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun Topological_sorting(N: Int) {
    val pq = PriorityQueue<Int>()
    val T = LinkedList<Int>()

    repeat(N) { i -> if (vertexR[i].size == 0) pq.offer(i) }

    while (pq.isNotEmpty()) {
        val i = pq.poll()
        T.offer(i + 1)

        vertex[i].forEach { if (--inDegree[it] == 0) pq.offer(it) }
    }

    println(T.joinToString(" "))
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = get(0)
    vertex = Array(N, { arrayListOf<Int>() })
    vertexR = Array(N, { arrayListOf<Int>() })
    inDegree = Array(N, { 0 })

    repeat(M) {
        val (A, B) = get(1)

        vertex[A] += B
        vertexR[B] += A
        inDegree[B]++
    }

    Topological_sorting(N)
}