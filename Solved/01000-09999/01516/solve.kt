import java.io.*
import java.util.*

lateinit var vertex: Array<ArrayList<Int>>
lateinit var vertexR: Array<ArrayList<Int>>
lateinit var time: Array<Int>

fun Topological_sort(N: Int) {
    val bTime = Array(N, { 0 })
    val queue = LinkedList<Int>()

    vertex.forEachIndexed { i, v ->
        if (v.size == 0) {
            bTime[i] = time[i]
            queue.offer(i)
        }
    }

    while (queue.isNotEmpty()) {
        vertexR[queue.poll()].forEach {
            if (bTime[it] == 0) {
                var flag = true
                var tmp = 0
                vertex[it].forEach { R ->
                    if (bTime[R] == 0) flag = false
                    else if (bTime[R] > tmp) tmp = bTime[R]
                }

                if (flag) {
                    bTime[it] = tmp + time[it]
                    queue.offer(it)
                }
            }
        }
    }

    println(bTime.joinToString("\n"))
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    vertex  = Array(N, { arrayListOf<Int>() })  // dependencies
    vertexR = Array(N, { arrayListOf<Int>() })  // workflow
    time = Array(N, { 0 })

    repeat(N) { i ->
        val l = readLine()!!.split(" ").map { it.toInt() }
        time[i] = l[0]

        repeat(l.size - 2) { j ->
            vertex[i] += l[1 + j] - 1
            vertexR[l[1 + j] - 1] += i
        }
    }

    Topological_sort(N)
}