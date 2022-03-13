import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    val vertex  = Array(N, { arrayListOf<Int>() })  // dependencies
    val vertexR = Array(N, { arrayListOf<Int>() })  // workflow
    val time = Array(N, { 0 })
    val fTime = Array(N, { 0 })

    val queue = LinkedList<Int>()

    repeat(N) { i ->
        val l = readLine()!!.split(" ").map { it.toInt() }
        time[i] = l[0]

        repeat(l[1]) { j ->
            vertex[i] += l[2 + j] - 1
            vertexR[l[2 + j] - 1] += i
        }
    }

    var mTime = 0
    vertex.forEachIndexed { i, v ->
        if (v.size == 0) {
            fTime[i] = time[i]
            if (fTime[i] > mTime) mTime = fTime[i]
            queue.offer(i)
        }
    }

    while (queue.isNotEmpty()) {
        vertexR[queue.poll()].forEach {
            if (fTime[it] == 0) {
                var flag = true
                var tmp = 0
                vertex[it].forEach { R ->
                    if (fTime[R] == 0) flag = false
                    else if (fTime[R] > tmp) tmp = fTime[R]
                }

                if (flag) {
                    fTime[it] = tmp + time[it]
                    if (fTime[it] > mTime) mTime = fTime[it]
                    queue.offer(it)
                }
            }
        }
    }

    println(mTime)
}