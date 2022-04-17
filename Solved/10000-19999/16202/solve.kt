import java.io.*
import java.util.*

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun Prim(vertex: Array<Array<Int>>, flag: Boolean): Pair<Int, Int> {
    val N = vertex.size
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))
    val visited = Array(N, { false })

    var sum = 0
    var min = 1001

    if (!flag) return Pair(0, 0)

    pq.offer(Pair(0, 0))

    while (pq.isNotEmpty()) {
        val (C, V) = pq.poll()

        if (visited[V]) continue
        visited[V] = true

        sum += C
        if (V != 0 && min > C) min = C

        repeat(N) { if (vertex[V][it] != 0 && !visited[it]) pq.offer(Pair(vertex[V][it], it)) }
    }

    repeat(N) { if(!visited[it]) return Pair(0, 0) }
    return Pair(sum, min)
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M, K) = get(0)
    val vertex = Array(N, { Array(N, { 0 }) })
    val turn   = Array(K, { 0 })

    repeat(M) { i ->
        val (x, y) = get(1)

        vertex[x][y] = i + 1
        vertex[y][x] = i + 1
    }

    var flag = true
    repeat(K) {
        var (sum, min) = Prim(vertex, flag)

        if (sum != 0) {
            turn[it] = sum

            repeat(N) { i -> repeat(N) { if (vertex[i][it] == min) vertex[i][it] = 0 } }
        }
        else flag = false
    }

    println(turn.joinToString(" "))
}