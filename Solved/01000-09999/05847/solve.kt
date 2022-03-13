import java.io.*
import java.util.*

lateinit var vertex: Array<ArrayList<Int>>
lateinit var inDegree: Array<Int>
lateinit var value: Array<Int>

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun Topological_sorting(N: Int) {
    val time = Array(N, { 0 })
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    var max = 0

    repeat(N) {
        if (inDegree[it] == 0) {
            time[it] = value[it]
            if (time[it] > max) max = time[it]
            queue.offer(Pair(value[it], it))
        }
    }

    while (queue.isNotEmpty()) {
        val (v, i) = queue.poll()
        
        vertex[i].forEach {
            if (v + value[it] > time[it]) {
                time[it] = v + value[it]
                if (time[it] > max) max = time[it]
            }

            if (--inDegree[it] == 0) {
                queue.offer(Pair(time[it], it))
            }
        }
    }

    println(max)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = get(0)
    vertex = Array(N, { arrayListOf<Int>() })
    inDegree = Array(N, { 0 })
    value = Array(N, { 0 })

    repeat(N) { value[it] = get(0)[0] }

    repeat(M) {
        val (A, B) = get(1)
        vertex[A] += B
        inDegree[B]++
    }

    Topological_sorting(N)
}