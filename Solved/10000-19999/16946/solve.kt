import java.io.*
import java.util.*

lateinit var arr: Array<Array<Int>>
lateinit var visited: Array<Array<Boolean>>

fun bfs(I: Int, J: Int) {
    val N = arr.size
    val M = arr[0].size

    val queue = LinkedList<Pair<Int, Int>>()
    val candidate = mutableSetOf<Pair<Int, Int>>()

    var cnt = 1
    visited[I][J] = false
    queue.offer(Pair(I, J))

    while (queue.isNotEmpty()) {
        val (i, j) = queue.poll()

        if (i > 0) {
            if (visited[i - 1][j]) {
                cnt++
                visited[i - 1][j] = false
                queue.offer(Pair(i - 1, j))
            }
            else if (arr[i - 1][j] > 0) candidate.add(Pair(i - 1, j))
        }

        if (j > 0) {
            if (visited[i][j - 1]) {
                cnt++
                visited[i][j - 1] = false
                queue.offer(Pair(i, j - 1))
            }
            else if (arr[i][j - 1] > 0) candidate.add(Pair(i, j - 1))
        }

        if (i < N - 1) {
            if (visited[i + 1][j]) {
                cnt++
                visited[i + 1][j] = false
                queue.offer(Pair(i + 1, j))
            }
            else if (arr[i + 1][j] > 0) candidate.add(Pair(i + 1, j))
        }

        if (j < M - 1) {
            if (visited[i][j + 1]) {
                cnt++
                visited[i][j + 1] = false
                queue.offer(Pair(i, j + 1))
            }
            else if (arr[i][j + 1] > 0) candidate.add(Pair(i, j + 1))
        }
    }

    candidate.forEach { (i, j) -> arr[i][j] += cnt }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    arr = Array(N, { Array(M, { 0 }) })
    visited = Array(N, { Array(M, { true }) })

    repeat(N) { i ->
        readLine().forEachIndexed { j, v ->
            arr[i][j] = v.code - 48
            if (v == '1') visited[i][j] = false
        }
    }

    repeat(N) { i ->
        repeat(M) { j ->
            if (visited[i][j]) bfs(i, j)
        }
    }

    arr.forEach { l ->
        l.forEach { bw.write("${it % 10}") }
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}