import java.io.*
import java.util.*

lateinit var vertex: Array<ArrayList<Int>>
lateinit var inDegree: Array<Int>

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun Topological_sorting(N: Int) {
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    val T = LinkedList<Int>()

    repeat(N) {
        if (inDegree[it] == 0) {
            queue.offer(Pair(0, it))
            T.offer(it + 1)
        }
    }

    while (queue.isNotEmpty()) {
        val (d, i) = queue.poll()

        vertex[i].forEach {
            if (--inDegree[it] == 0) {
                queue.offer(Pair(d + 1, it))
                T.offer(it + 1)
            }
        }
    }

    println(if (inDegree.sum() == 0) T.joinToString("\n") else 0)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = get(0)
    vertex = Array(N, { arrayListOf<Int>() })
    inDegree = Array(N, { 0 })

    repeat(M) {
        val l = get(1)

        repeat(l[0]) {
            vertex[l[it + 1]] += l[it + 2]
            inDegree[l[it + 2]]++
        }
    }

    Topological_sorting(N)
}