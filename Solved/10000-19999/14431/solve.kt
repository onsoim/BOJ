import java.io.*
import java.util.*

import kotlin.math.*

const val INF = Int.MAX_VALUE

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun is_prime(N: Int): Boolean {
    var i = 3

    if (N % 2 == 0 && N == 2) return true
    else if (N == 1 || N % 2 == 0) return false

    while(i * i <= N) {
        if(N % i == 0) return false
        i += 2
    }

    return true
}

fun dijkstra(vertex: Array<ArrayList<Pair<Int, Int>>>): Int {
    val N = vertex.size
    val dist = Array(N, { INF })
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))

    dist[0] = 0
    queue.offer(Pair(0, 0))

    do {
        val (cost, x) = queue.poll()

        if (cost <= dist[x]) {
            vertex[x].forEach {
                val tmp = cost + it.second

                if (dist[it.first] > tmp) {
                    queue.offer(Pair(tmp, it.first))
                    dist[it.first] = tmp
                }
            }
        }
    } while (queue.isNotEmpty())

    return if (dist[N - 1] == INF) -1 else dist[N - 1]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (X1, Y1, X2, Y2) = get()
    val N = get()[0]
    val coor = arrayListOf<Pair<Int, Int>>()

    coor += Pair(X1, Y1)
    repeat(N) {
        val (X3, Y3) = get()
        coor += Pair(X3, Y3)
    }
    coor += Pair(X2, Y2)

    val arr = Array(N + 2, { arrayListOf<Pair<Int, Int>>() })
    coor.forEachIndexed { i, iv ->
        coor.forEachIndexed { j, jv ->
            if (i < j) {
                val d = sqrt(
                    (iv.first - jv.first).toDouble().pow(2) +
                    (iv.second - jv.second).toDouble().pow(2)
                ).toInt()
                if (is_prime(d)) {
                    arr[i] += Pair(j, d)
                    arr[j] += Pair(i, d)
                }
            }
        }
    }

    println(dijkstra(arr))
}