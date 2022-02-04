import java.io.*
import java.util.*

fun floyd_warshall(N: Int, arr: Array<Array<Int>>) {
    repeat(N) { i->
        repeat(N) { j->
            repeat(N) { k->
                if (arr[j][i] == arr[i][k] && arr[j][k] == 0) arr[j][k] = arr[j][i]
            }
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    val M = readLine()!!.toInt()

    val arr = Array(N, { Array(N, { 0 }) })

    repeat(M) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() - 1 }
        arr[a][b] = -1
        arr[b][a] = 1
    }

    floyd_warshall(N, arr)
    arr.forEach { println(it.count { it == 0 } - 1) }
}