import java.io.*
import java.util.*

lateinit var vertex:  Array<ArrayList<Int>>
lateinit var vertexR: Array<ArrayList<Int>>
lateinit var inDegree: Array<Int>

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun Topological_sort(M: Int): Int {
    val Strahler = Array(M, { 0 })
    val queue = LinkedList<Int>()

    inDegree.forEachIndexed { i, v ->
        if (v == 0) {
            queue.offer(i)
            Strahler[i]++
        }
    }

    while (queue.isNotEmpty()) {
        val i = queue.poll()

        vertex[i].forEach {
            if (Strahler[it] == 0) {
                var flag = true
                var MAX = 0
                var cnt = 0
                vertexR[it].forEach { R ->
                    if (Strahler[R] == 0) flag = false
                    else if (Strahler[R] == MAX) cnt++
                    else if (Strahler[R] > MAX) {
                        MAX = Strahler[R]
                        cnt = 1
                    }
                }

                if (flag) {
                    Strahler[it] = MAX
                    if (cnt > 1) Strahler[it]++
                    queue.offer(it)
                }
            }
        }
    }

    return Strahler[M - 1]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val T = get(0)[0]

    repeat (T) {
        val (K, M, P) = get(0)

        vertex  = Array(M, { arrayListOf<Int>() })
        vertexR = Array(M, { arrayListOf<Int>() })
        inDegree = Array(M, { 0 })

        repeat(P) {
            val (A, B) = get(1)

            vertex[A]  += B
            vertexR[B] += A
            inDegree[B]++
        }

        println("${K} ${Topological_sort(M)}")
    }
}