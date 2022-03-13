import java.io.*
import java.util.*

lateinit var vertex: Array<ArrayList<Pair<Int, Int>>>
lateinit var inDegree: Array<Int>

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun Topological_sorting(n: Int) {
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    val cond = Array(n, { 0 })

    repeat(n) { i ->
        if (inDegree[i] == 0) queue.offer(Pair(0, i))
    }

    var max = 0
    while (queue.isNotEmpty()) {
        val (c, i) = queue.poll()

        vertex[i].forEach { (j, v) ->
            if (cond[j] < c + v) {
                cond[j] = c + v
                if (cond[j] > max) max = cond[j]
            }

            if (--inDegree[j] == 0) {
                queue.offer(Pair(cond[j], j))
            }
        }
    }

    println(max)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = get()
    vertex = Array(n, { arrayListOf<Pair<Int, Int>>() })
    inDegree = Array(n, { 0 })

    repeat(m) {
        val (s, t, c) = get()
        vertex[s - 1] += Pair(t - 1, c)
        inDegree[t - 1]++
    }

    Topological_sorting(n)
}