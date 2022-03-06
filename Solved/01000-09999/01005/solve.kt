import java.io.*
import java.util.*

lateinit var vertex: Array<ArrayList<Int>>
lateinit var inDegree: Array<Int>
lateinit var D: List<Int>

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun Topological_sort(N: Int, W: Int) {
    val visited = Array(N, { 0 })
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))

    inDegree.forEachIndexed { i, v ->
        if (v == 0) {
            queue.offer(Pair(D[i], i))
            visited[i] = D[i]
        }
    }

    while (queue.isNotEmpty()) {
        val (d, i) = queue.poll()

        vertex[i].forEach {
            if (--inDegree[it] == 0 && visited[it] == 0) {
                queue.offer(Pair(d + D[it], it))
                visited[it] = d + D[it]
            }
        }
    }

    println(visited[W])
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(get(0)[0]) {
        val (N, K) = get(0)
        vertex = Array(N, { arrayListOf<Int>() })
        inDegree = Array(N, { 0 })

        D = get(0)

        repeat(K) {
            val (A, B) = get(1)
            vertex[A] += B
            inDegree[B]++
        }

        Topological_sort(N, get(0)[0] - 1)
    }
    
}